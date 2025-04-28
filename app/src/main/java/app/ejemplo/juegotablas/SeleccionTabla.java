package app.ejemplo.juegotablas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
//ADMOB
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class SeleccionTabla extends AppCompatActivity {
    //ADMOB
    private FrameLayout adContainerView;
    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private  static String TAG="ADMOB";
    //APP
private ImageView starTableOne,starTableTwo,starTableThree,starTableFour,starTableFive,starTableSix,starTableSeven,starTableEight,starTableNine,starTableTen;
private int scoreTableOne,scoreTableTwo,scoreTableThree,scoreTableFour,scoreTableFive,scoreTableSix,scoreTableSeven,scoreTableEight,scoreTableNine,scoreTableTen;
private int selectedTable,scorean;
    private int scoreTableRandomOne,scoreTableRandomTwo,scoreTableRandomThree,scoreTableRandomFour,scoreTableRandomFive,scoreTableRandomSix,scoreTableRandomSeven,scoreTableRandomEight,scoreTableRandomNine,scoreTableRandomTen;
private  String gameMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_tabla);
        //ADMOB
        RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration()
                .toBuilder()
                .setTagForChildDirectedTreatment(RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                .build();
        MobileAds.setRequestConfiguration(requestConfiguration);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                loadIntersticialAd();
            }
        });
        adContainerView = findViewById(R.id.id_FrameLayout);
        // Step 1 - Create an AdView and set the ad unit ID on it.
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.adaptive_banner_ad_unit_id));
        adContainerView.addView(adView);
        loadBanner();

        //APP
        starTableOne=findViewById(R.id.imageView1);
        starTableTwo=findViewById(R.id.imageView2);
        starTableThree=findViewById(R.id.imageView3);
        starTableFour=findViewById(R.id.imageView4);
        starTableFive=findViewById(R.id.imageView5);
        starTableSix=findViewById(R.id.imageView6);
        starTableSeven=findViewById(R.id.imageView7);
        starTableEight=findViewById(R.id.imageView8);
        starTableNine=findViewById(R.id.imageView9);
        starTableTen=findViewById(R.id.imageView10);
        ImageButton tableOne=findViewById(R.id.imageButton1);
        ImageButton tableTwo=findViewById(R.id.imageButton2);
        ImageButton tableThree=findViewById(R.id.imageButton3);
        ImageButton tableFour=findViewById(R.id.imageButton4);
        ImageButton tableFive=findViewById(R.id.imageButton5);
        ImageButton tableSix=findViewById(R.id.imageButton6);
        ImageButton tableSeven=findViewById(R.id.imageButton7);
        ImageButton tableEight=findViewById(R.id.imageButton8);
        ImageButton tableNine=findViewById(R.id.imageButton9);
        ImageButton tableTen=findViewById(R.id.imageButton10);
        selectedTable=1;
        gameMode=getIntent().getStringExtra("mode");
        if(gameMode.equals("modeS")==true) {
            SharedPreferences preferences= getSharedPreferences("score", Context.MODE_PRIVATE);
            scoreTableOne=preferences.getInt("scoreTableOne",0);
            scoreTableTwo=preferences.getInt("scoreTableTwo",0);
            scoreTableThree=preferences.getInt("scoreTableThree",0);
            scoreTableFour=preferences.getInt("scoreTableFour",0);
            scoreTableFive=preferences.getInt("scoreTableFive",0);
            scoreTableSix=preferences.getInt("scoreTableSix",0);
            scoreTableSeven=preferences.getInt("scoreTableSeven",0);
            scoreTableEight=preferences.getInt("scoreTableEigth",0);
            scoreTableNine=preferences.getInt("scoreTableNine",0);
            scoreTableTen=preferences.getInt("scoreTableTen",0);
            starRitingOne(scoreTableOne);
            starRitingTwo(scoreTableTwo);
            starRitingThree(scoreTableThree);
            starRitingFour(scoreTableFour);
            starRitingFive(scoreTableFive);
            starRitingSix(scoreTableSix);
            starRitingSeven(scoreTableSeven);
            starRitingEight(scoreTableEight);
            starRitingNine(scoreTableNine);
            starRitingTen(scoreTableTen);
        }else{
            SharedPreferences preferences= getSharedPreferences("score", Context.MODE_PRIVATE);
            scoreTableRandomOne=preferences.getInt("scoreTableOneR",0);
            scoreTableRandomTwo=preferences.getInt("scoreTableTwoR",0);
            scoreTableRandomThree=preferences.getInt("scoreTableThreeR",0);
            scoreTableRandomFour=preferences.getInt("scoreTableFourR",0);
            scoreTableRandomFive=preferences.getInt("scoreTableFiveR",0);
            scoreTableRandomSix=preferences.getInt("scoreTableSixR",0);
            scoreTableRandomSeven=preferences.getInt("scoreTableSevenR",0);
            scoreTableRandomEight=preferences.getInt("scoreTableEigthR",0);
            scoreTableRandomNine=preferences.getInt("scoreTableNineR",0);
            scoreTableRandomTen=preferences.getInt("scoreTableTenR",0);
            starRitingOne(scoreTableRandomOne);
            starRitingTwo(scoreTableRandomTwo);
            starRitingThree(scoreTableRandomThree);
            starRitingFour(scoreTableRandomFour);
            starRitingFive(scoreTableRandomFive);
            starRitingSix(scoreTableRandomSix);
            starRitingSeven(scoreTableRandomSeven);
            starRitingEight(scoreTableRandomEight);
            starRitingNine(scoreTableRandomNine);
            starRitingTen(scoreTableRandomTen);

        }
        tableOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableOne;
                }else{
                    scorean=scoreTableRandomOne;
                }
                selectedTable=1;
                loadI();
            }
        });
        tableTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableTwo;
                }else{
                    scorean=scoreTableRandomTwo;
                }
                selectedTable=2;
                loadI();

            }
        });
        tableThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableThree;
                }else{
                    scorean=scoreTableRandomThree;
                }
                selectedTable=3;
                loadI();
            }
        });
        tableFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableFour;
                }else{
                    scorean=scoreTableRandomFour;
                }
                selectedTable=4;
                loadI();
            }
        });
        tableFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableFive;
                }else{
                    scorean=scoreTableRandomFive;
                }
                selectedTable=5;
                loadI();

            }
        });
        tableSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableSix;
                }else{
                    scorean=scoreTableRandomSix;
                }
                selectedTable=6;
                loadI();
            }
        });
        tableSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableSeven;
                }else{
                    scorean=scoreTableRandomSeven;
                }
                selectedTable=7;
                loadI();
            }
        });
        tableEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableEight;
                }else{
                    scorean=scoreTableRandomEight;
                }
                selectedTable=8;
                loadI();

            }
        });
        tableNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableNine;
                }else{
                    scorean=scoreTableRandomNine;
                }
                selectedTable=9;
                loadI();
            }
        });
        tableTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameMode.equals("modeS")==true){
                    scorean=scoreTableTen;
                }else{
                    scorean=scoreTableRandomTen;
                }
                selectedTable=10;
                loadI();
            }
        });
    }
    public  void changeStart(){
        Intent i = new Intent(this,MultiplicationTables.class);
        i.putExtra("selected",selectedTable);
        i.putExtra("mode",gameMode);
        i.putExtra("scorean",scorean);

        startActivity(i);
    }
    public void starRitingOne(int score){
    if(score==0){
        starTableOne.setImageResource(R.drawable.cerostaruno);
    }
    else if(score>=1&&score<=2){
        starTableOne.setImageResource(R.drawable.unodosstaruno);
    }else if(score>=3&&score<=4){
        starTableOne.setImageResource(R.drawable.trescuatrostaruno);
    }else if(score==5){
        starTableOne.setImageResource(R.drawable.cincostaruno);
    }else if(score>=6&&score<=7){
        starTableOne.setImageResource(R.drawable.seisietestaruno);
    }else if(score>=8&&score<=9){
        starTableOne.setImageResource(R.drawable.ochonuevestaruno);
    }else{
        starTableOne.setImageResource(R.drawable.diezstaruno);
    }
    }
    public void starRitingTwo(int score){
        if(score==0){
            starTableTwo.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableTwo.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableTwo.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableTwo.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableTwo.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableTwo.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableTwo.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingThree(int score){
        if(score==0){
            starTableThree.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableThree.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableThree.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableThree.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableThree.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableThree.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableThree.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingFour(int score){
        if(score==0){
            starTableFour.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableFour.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableFour.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableFour.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableFour.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableFour.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableFour.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingFive(int score){
        if(score==0){
            starTableFive.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableFive.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableFive.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableFive.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableFive.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableFive.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableFive.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingSix(int score){
        if(score==0){
            starTableSix.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableSix.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableSix.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableSix.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableSix.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableSix.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableSix.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingSeven(int score){
        if(score==0){
            starTableSeven.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableSeven.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableSeven.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableSeven.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableSeven.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableSeven.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableSeven.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingEight(int score){
        if(score==0){
            starTableEight.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableEight.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableEight.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableEight.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableEight.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableEight.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableEight.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingNine(int score){
        if(score==0){
            starTableNine.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableNine.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableNine.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableNine.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableNine.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableNine.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableNine.setImageResource(R.drawable.diezstaruno);
        }
    }
    public void starRitingTen(int score){
        if(score==0){
            starTableTen.setImageResource(R.drawable.cerostaruno);
        }
        else if(score>=1&&score<=2){
            starTableTen.setImageResource(R.drawable.unodosstaruno);
        }else if(score>=3&&score<=4){
            starTableTen.setImageResource(R.drawable.trescuatrostaruno);
        }else if(score==5){
            starTableTen.setImageResource(R.drawable.cincostaruno);
        }else if(score>=6&&score<=7){
            starTableTen.setImageResource(R.drawable.seisietestaruno);
        }else if(score>=8&&score<=9){
            starTableTen.setImageResource(R.drawable.ochonuevestaruno);
        }else{
            starTableTen.setImageResource(R.drawable.diezstaruno);
        }
    }
    //ADMOB BANNER
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
    //Intersticial
    public void loadI(){
        if (mInterstitialAd != null) {
            mInterstitialAd.show(SeleccionTabla.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            Toast.makeText(SeleccionTabla.this,getString(R.string.Toast),Toast.LENGTH_SHORT).show();
        }
    }
    private void loadIntersticialAd(){

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,getString(R.string.adaptive_intersticial_ad_unit_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when fullscreen content is dismissed.
                                Log.d("TAG", "The ad was dismissed.");
                                changeStart();
                                loadIntersticialAd();

                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when fullscreen content is shown.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                mInterstitialAd = null;
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

    }
}