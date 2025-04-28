package app.ejemplo.juegotablas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class MultiplicationTables extends AppCompatActivity {
    //ADMOB
    private FrameLayout adContainerView;
    private AdView adView;
    private static String TAG="Recompensado";
    private RewardedAd mRewardedAd;
    //APP
    private ImageButton starGame;
    private ImageView  mulTable,rank;
    private  int selectedTable,multiply,scorean,recompensa;
    private  String gameMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_tables);
        //ADMOB
        recompensa=0;
        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration()
                .toBuilder()
                .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                loadRewardedAd();
            }
        });

        adContainerView = findViewById(R.id.id_FrameLayout);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.adaptive_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();
        //APP
        gameMode=getIntent().getStringExtra("mode");
        scorean=getIntent().getIntExtra("scorean",0);
        multiply=1;
        selectedTable=getIntent().getIntExtra("selected",0);
        starGame=(ImageButton)findViewById(R.id.imageButton);
        mulTable=(ImageView)findViewById(R.id.imageView);
        rank=(ImageView)findViewById(R.id.imageView11);
        changeImageView();
        changeImageViewRank();
        starGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mRewardedAd != null) {
                    Activity activityContext = MultiplicationTables.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            // Handle the reward.
                            Log.d(TAG, "The user earned the reward.");
                            int rewardAmount = rewardItem.getAmount();
                            String rewardType = rewardItem.getType();
                            recompensa++;
                        }
                    });
                } else {
                    Log.d(TAG, "The rewarded ad wasn't ready yet.");
                    Toast.makeText(MultiplicationTables.this,getString(R.string.Toast),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void changeImageView(){
        switch (selectedTable){
            case 1:mulTable.setImageResource(R.drawable.tablauno);break;
            case 2:mulTable.setImageResource(R.drawable.tablados);break;
            case 3:mulTable.setImageResource(R.drawable.tablatres);break;
            case 4:mulTable.setImageResource(R.drawable.tablacuatro);break;
            case 5:mulTable.setImageResource(R.drawable.tablacinco);break;
            case 6:mulTable.setImageResource(R.drawable.tablaseis);break;
            case 7:mulTable.setImageResource(R.drawable.tablasiete);break;
            case 8:mulTable.setImageResource(R.drawable.tablaocho);break;
            case 9:mulTable.setImageResource(R.drawable.tablanueve);break;
            case 10:mulTable.setImageResource(R.drawable.tabladiez);break;
            default:mulTable.setImageResource(R.drawable.tabladiez);break;
        }
    }
    public void changeImageViewRank(){
        switch (scorean){
            case 1:rank.setImageResource(R.drawable.unodosstardos);break;
            case 2:rank.setImageResource(R.drawable.unodosstardos);break;
            case 3:rank.setImageResource(R.drawable.trescuatrostardos);break;
            case 4:rank.setImageResource(R.drawable.trescuatrostardos);break;
            case 5:rank.setImageResource(R.drawable.cincostardos);break;
            case 6:rank.setImageResource(R.drawable.seissietestardos);break;
            case 7:rank.setImageResource(R.drawable.seissietestardos);break;
            case 8:rank.setImageResource(R.drawable.ochonuevestardos);break;
            case 9:rank.setImageResource(R.drawable.ochonuevestardos);break;
            case 10:rank.setImageResource(R.drawable.complestardos);break;
            default:rank.setImageResource(R.drawable.cerostardos);break;
        }
    }
    public void goStartGameMode(){
        if(gameMode.equals("modeS")==true) {
            Intent starIntent = new Intent(this, StartGameMode.class);
            starIntent.putExtra("selectedTable", selectedTable);
            starIntent.putExtra("mul", multiply);
            starIntent.putExtra("score", 0);
            starIntent.putExtra("mode", gameMode);
            startActivity(starIntent);
        }else{

            Intent starIntent = new Intent(this, StartGameModeRandom.class);
            starIntent.putExtra("selectedTable", selectedTable);
            starIntent.putExtra("score", 0);
            starIntent.putExtra("cont", 0);
            starIntent.putExtra("mode", gameMode);
            starIntent.putExtra("numOb", "");
            startActivity(starIntent);
        }
    }
    private void loadBanner() {
        AdRequest adRequest = new AdRequest.Builder().build();
        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);
        adView.loadAd(adRequest);
    }
    private AdSize getAdSize() {
        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        // Step 3 - Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
    //Recompensado
    private void loadRewardedAd(){
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, getString(R.string.adaptive_recompensado_ad_unit_id),
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error.
                        Log.d(TAG, loadAdError.getMessage());
                        mRewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        mRewardedAd = rewardedAd;
                        Log.d(TAG, "Ad was loaded.");
                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when ad is shown.
                                Log.d(TAG, "Ad was shown.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when ad fails to show.
                                Log.d(TAG, "Ad failed to show.");
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when ad is dismissed.
                                // Set the ad reference to null so you don't show the ad a second time.
                                Log.d(TAG, "Ad was dismissed.");
                                mRewardedAd = null;
                                if(recompensa>=1){
                                    goStartGameMode();

                                }else{
                                    goStartGameMode();

                                }
                            }
                        });
                    }
                });
    }
}