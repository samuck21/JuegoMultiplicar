package app.ejemplo.juegotablas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
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

public class Scores extends AppCompatActivity {
    //ADMOB
    private static String TAG="Recompensado";
    private RewardedAd mRewardedAd;
    //APP
private int selectedTable,primero,segundo,tercero;
private  String gameMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
//ADMOB
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


        TextView textViewScore=(TextView)findViewById(R.id.textView20);
        TextView textViewNote=(TextView)findViewById(R.id.textView21);
        ImageView imageViewStartRank=(ImageView)findViewById(R.id.imageView14);
        ImageButton continueSave=(ImageButton)findViewById(R.id.imageButton17);
        ImageButton restartGame=(ImageButton)findViewById(R.id.imageButton16);
        selectedTable=getIntent().getIntExtra("selectedTable",0);
        gameMode=getIntent().getStringExtra("mode");
        int score=getIntent().getIntExtra("score",0);
        SharedPreferences preferences= getSharedPreferences("score", Context.MODE_PRIVATE);
        primero=preferences.getInt("scoreOne",0);
        segundo=preferences.getInt("scoreTwo",0);
        tercero=preferences.getInt("scoreThree",0);
        String stringScore=String.valueOf(score);
        textViewScore.setText(stringScore);
        switch (score){
            case 0:{imageViewStartRank.setImageResource(R.drawable.cerostarp);
            textViewNote.setText(getString(R.string.scores_cinco));
            }break;
            case 1:{imageViewStartRank.setImageResource(R.drawable.unodosstarp);
                textViewNote.setText(getString(R.string.scores_cinco));
            }break;
            case 2:{imageViewStartRank.setImageResource(R.drawable.unodosstarp);
                textViewNote.setText(getString(R.string.scores_cinco));
            }break;
            case 3:{imageViewStartRank.setImageResource(R.drawable.trescuatrostarp);
                textViewNote.setText(getString(R.string.scores_cinco));
            }break;
            case 4:{imageViewStartRank.setImageResource(R.drawable.trescuatrostarp);
                textViewNote.setText(getString(R.string.scores_cinco));
            }break;
            case 5:{imageViewStartRank.setImageResource(R.drawable.cincostarp);
                textViewNote.setText(getString(R.string.scores_cinco));
            }break;
            case 6:{imageViewStartRank.setImageResource(R.drawable.seissietestarp);
                textViewNote.setText(getString(R.string.scores_cuatro));
            }break;
            case 7:{imageViewStartRank.setImageResource(R.drawable.seissietestarp);
                textViewNote.setText(getString(R.string.scores_cuatro));
            }break;
            case 8:{imageViewStartRank.setImageResource(R.drawable.ochonuevezstarp);
                textViewNote.setText(getString(R.string.scores_tres));
            }break;
            case 9:{imageViewStartRank.setImageResource(R.drawable.ochonuevezstarp);
                textViewNote.setText(getString(R.string.scores_tres));
            }break;
            case 10:{imageViewStartRank.setImageResource(R.drawable.starcompletaspun);
                textViewNote.setText(getString(R.string.scores_dos));
            }break;
            default:{imageViewStartRank.setImageResource(R.drawable.cerostarp);
                textViewNote.setText(getString(R.string.scores_cinco));
            }break;
        }
        restartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder newDialog = new AlertDialog.Builder(Scores.this);
                newDialog.setTitle(getString(R.string.star_game_mode_cuatro));
                newDialog.setMessage(getString(R.string.star_game_mode_cinco));
                newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                    restartGame();
                    dialogInterface.dismiss();
                });
                newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
                newDialog.show();
            }
        });
        continueSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mRewardedAd != null) {
                    Activity activityContext = Scores.this;
                    mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                            // Handle the reward.
                            Log.d(TAG, "The user earned the reward.");
                            int rewardAmount = rewardItem.getAmount();
                            String rewardType = rewardItem.getType();
                        }
                    });
                SharedPreferences preferences = getSharedPreferences("score", Context.MODE_PRIVATE);
                SharedPreferences.Editor Ob=preferences.edit();
                if(gameMode.equals("modeS")==true){
              switch (selectedTable){
                  case 1:{Ob.putInt("scoreTableOne",score); Ob.commit(); }break;
                  case 2:{Ob.putInt("scoreTableTwo",score); Ob.commit(); }break;
                  case 3:{Ob.putInt("scoreTableThree",score); Ob.commit(); }break;
                  case 4:{Ob.putInt("scoreTableFour",score); Ob.commit(); }break;
                  case 5:{Ob.putInt("scoreTableFive",score); Ob.commit(); }break;
                  case 6:{Ob.putInt("scoreTableSix",score); Ob.commit(); }break;
                  case 7:{Ob.putInt("scoreTableSeven",score); Ob.commit(); }break;
                  case 8:{Ob.putInt("scoreTableEigth",score); Ob.commit(); }break;
                  case 9:{Ob.putInt("scoreTableNine",score); Ob.commit(); }break;
                  case 10:{Ob.putInt("scoreTableTen",score); Ob.commit(); }break;

              }

                }else if(gameMode.equals("modeR")==true){
                    switch (selectedTable) {
                        case 1: { Ob.putInt("scoreTableOneR", score);Ob.commit(); }break;
                        case 2: { Ob.putInt("scoreTableTwoR", score);Ob.commit(); }break;
                        case 3: { Ob.putInt("scoreTableThreeR", score);Ob.commit(); }break;
                        case 4: { Ob.putInt("scoreTableFourR", score);Ob.commit(); }break;
                        case 5: { Ob.putInt("scoreTableFiveR", score);Ob.commit(); }break;
                        case 6: { Ob.putInt("scoreTableSixR", score);Ob.commit(); }break;
                        case 7: { Ob.putInt("scoreTableSevenR", score);Ob.commit(); }break;
                        case 8: { Ob.putInt("scoreTableEigthR", score);Ob.commit(); }break;
                        case 9: { Ob.putInt("scoreTableNineR", score);Ob.commit(); }break;
                        case 10: { Ob.putInt("scoreTableTenR", score);Ob.commit(); }break;

                    }
                }else{
                    if(score>=primero){
                        tercero=segundo;
                        segundo=primero;
                        primero=score;
                    }else if(score>=segundo&&score<primero){
                        tercero=segundo;
                        segundo=score;
                    }else if(score>=tercero&&score<segundo){
                        tercero=score;
                    }

                    Ob.putInt("scoreOne",primero);
                    Ob.putInt("scoreTwo",segundo);
                    Ob.putInt("scoreTree",tercero);
                    Ob.commit();

                }
                } else {
                    Log.d(TAG, "The rewarded ad wasn't ready yet.");
                    Toast.makeText(Scores.this,getString(R.string.Toast),Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    public void  returnSelectionTable(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public  void restartGame(){
        if(gameMode.equals("modeS")==true) {
            Intent intent = new Intent(this, StartGameMode.class);
            intent.putExtra("selectedTable", selectedTable);
            intent.putExtra("mul", 1);
            intent.putExtra("score", 0);
            startActivity(intent);
        }else if(gameMode.equals("modeR")==true){
            Intent intent= new Intent(this,StartGameModeRandom.class);
            intent.putExtra("selectedTable",selectedTable);
            intent.putExtra("score",0);
            intent.putExtra("mode",gameMode);
            intent.putExtra("cont", 0);
            intent.putExtra("numOb", "");
            startActivity(intent);
        } else{
            Intent intent= new Intent(this,StartHardRandomMode.class);
            intent.putExtra("score",0);
            intent.putExtra("mode",gameMode);
            intent.putExtra("cont", 0);
            startActivity(intent);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            AlertDialog.Builder newDialog = new AlertDialog.Builder(Scores.this);
            newDialog.setTitle(getString(R.string.salir_app));
            newDialog.setMessage(getString(R.string.score));
            newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                returnActivity();
                dialogInterface.dismiss();
            });
            newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                dialogInterface.cancel();
            });
            newDialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
    public  void returnActivity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
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
                                returnSelectionTable();
                            }
                        });
                    }
                });
    }

}