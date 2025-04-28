package app.ejemplo.juegotablas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class StartHardRandomMode extends AppCompatActivity {
    private  int selectedTable,multiply,resultA,resultB,resultC,resultD,score,avoidChange,cont;
    private ImageButton optionA,optionB,optionC,optionD,imageButtonRestart;
    private TextView optionATextView, optionBTextView, optionCTextView, optionDTextView,textViewScore,note;
    private CountDownTimer countDownTimer;
    private String gameMode,pastNumbers;
    private  long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_hard_random_mode);
        AppProcesses appProcesses= new AppProcesses();
        avoidChange=0;
        optionA=(ImageButton)findViewById(R.id.imageButton12);
        optionB=(ImageButton)findViewById(R.id.imageButton11);
        optionC=(ImageButton)findViewById(R.id.imageButton13);
        optionD=(ImageButton)findViewById(R.id.imageButton14);
        imageButtonRestart=(ImageButton)findViewById(R.id.imageButton15);
        note=(TextView)findViewById(R.id.textView14);
        TextView multiplicationTable=(TextView)findViewById(R.id.textView15);
        optionATextView=(TextView)findViewById(R.id.textView16);
        optionBTextView=(TextView)findViewById(R.id.textView17);
        optionCTextView=(TextView)findViewById(R.id.textView18);
        optionDTextView=(TextView)findViewById(R.id.textView19);
        textViewScore=(TextView)findViewById(R.id.textView13);
        TextView chronometerTextView=(TextView)findViewById(R.id.textView12);
        score=getIntent().getIntExtra("score",0);
        gameMode=getIntent().getStringExtra("mode");
        cont=getIntent().getIntExtra("cont",0);
        if(cont<20){
            String scoreString=getString(R.string.star_game_mode)+String.valueOf(score);
            textViewScore.setText(scoreString);
            multiply=appProcesses.randomIntNumber(11);
            String multiplyString=String.valueOf(multiply);
            selectedTable=appProcesses.randomIntNumber(11);
            String selectedTableString=String.valueOf(selectedTable);
            multiplyString=String.valueOf(multiply);
            String Display=selectedTableString+"x"+multiplyString+"=";
            multiplicationTable.setText(Display);
            time=15*1000;
            countDownTimer=new CountDownTimer(time,1000) {
                @Override
                public void onTick(long l) {
                    long t=l/1000;
                    long seg=t%60;
                    String segString=String.valueOf(seg);
                    chronometerTextView.setText(segString+"s ");
                }

                @Override
                public void onFinish() {
                    avoidChange++;
                    countDownTimer.cancel();
                    incorrectOption();

                }
            }.start();

            int randomButton=appProcesses.randomIntNumber(5);
            switch (randomButton){
                case 1:optionButtonA();break;
                case 2:optionButtonB();break;
                case 3:optionButtonC();break;
                case 4:optionButtonD();break;
                default:optionButtonD();break;
            }

            optionA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int multuplicationResult=selectedTable*multiply;
                    if(avoidChange==0){
                        if(multuplicationResult==resultA){
                            optionA.setImageResource(R.drawable.opcioncorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            correctOption();


                        }else{
                            optionA.setImageResource(R.drawable.opcionincorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            incorrectOption();
                        }
                    }
                }
            });
            optionB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int multuplicationResult=selectedTable*multiply;
                    if(avoidChange==0){
                        if(multuplicationResult==resultB){
                            optionB.setImageResource(R.drawable.opcioncorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            correctOption();
                        }else{
                            optionB.setImageResource(R.drawable.opcionincorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            incorrectOption();
                        }

                    }
                }
            });
            optionC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int multuplicationResult = selectedTable * multiply;
                    if (avoidChange == 0) {
                        if (multuplicationResult == resultC) {
                            optionC.setImageResource(R.drawable.opcioncorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            correctOption();
                        } else {
                            optionC.setImageResource(R.drawable.opcionincorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            incorrectOption();
                        }
                    }
                }
            });
            optionD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int multuplicationResult=selectedTable*multiply;
                    if(avoidChange==0){
                        if(multuplicationResult==resultD){
                            optionD.setImageResource(R.drawable.opcioncorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            correctOption();
                        }else{
                            optionD.setImageResource(R.drawable.opcionincorrecta);
                            avoidChange++;
                            countDownTimer.cancel();
                            incorrectOption();
                        }
                    }
                }
            });
            imageButtonRestart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                    AlertDialog.Builder newDialog = new AlertDialog.Builder(StartHardRandomMode.this);
                    newDialog.setTitle(getString(R.string.star_game_mode_cuatro));
                    newDialog.setMessage(getString(R.string.star_game_mode_cinco));
                    newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                        restartGame();
                        dialogInterface.dismiss();
                    });
                    newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                        countDownTimer.start();
                        dialogInterface.cancel();
                    });
                    newDialog.show();
                }
            });

        }
        else{
            Intent intent= new Intent(this,Scores.class);
            intent.putExtra("selectedTable",selectedTable);
            intent.putExtra("score",score);
            intent.putExtra("mode",gameMode);
            startActivity(intent);
            finish();
        }

    }
    public void optionButtonA(){
        AppProcesses appProcesses= new AppProcesses();
        resultA=appProcesses.multiplication(selectedTable,multiply);
        String resultStringA=String.valueOf(resultA);
        optionATextView.setText(resultStringA);
        resultB=appProcesses.multiplicationMinusOne(selectedTable,multiply);
        String resultStringB=String.valueOf(resultB);
        optionBTextView.setText(resultStringB);
        resultC=appProcesses.randomIntNumberTwo(10,selectedTable);
        String resultStringC=String.valueOf(resultC);
        optionCTextView.setText(resultStringC);
        resultD=appProcesses.multiplicationPlusOne(selectedTable,multiply);
        String resultStringD=String.valueOf(resultD);
        optionDTextView.setText(resultStringD);
    }
    public void optionButtonB(){
        AppProcesses appProcesses= new AppProcesses();
        resultA=appProcesses.multiplicationPlusOne(selectedTable,multiply);
        String resultStringA=String.valueOf(resultA);
        optionATextView.setText(resultStringA);
        resultB=appProcesses.multiplication(selectedTable,multiply);
        String resultStringB=String.valueOf(resultB);
        optionBTextView.setText(resultStringB);
        resultC=appProcesses.multiplicationMinusOne(selectedTable,multiply);
        String resultStringC=String.valueOf(resultC);
        optionCTextView.setText(resultStringC);
        resultD=appProcesses.randomIntNumberTwo(10,selectedTable);
        String resultStringD=String.valueOf(resultD);
        optionDTextView.setText(resultStringD);
    }
    public void optionButtonC(){
        AppProcesses appProcesses= new AppProcesses();
        resultA=appProcesses.randomIntNumberTwo(10,selectedTable);
        String resultStringA=String.valueOf(resultA);
        optionATextView.setText(resultStringA);
        resultB=appProcesses.multiplicationPlusOne(selectedTable,multiply);
        String resultStringB=String.valueOf(resultB);
        optionBTextView.setText(resultStringB);
        resultC=appProcesses.multiplication(selectedTable,multiply);
        String resultStringC=String.valueOf(resultC);
        optionCTextView.setText(resultStringC);
        resultD=appProcesses.multiplicationMinusOne(selectedTable,multiply);
        String resultStringD=String.valueOf(resultD);
        optionDTextView.setText(resultStringD);
    }
    public void optionButtonD(){
        AppProcesses appProcesses= new AppProcesses();
        resultA=appProcesses.multiplicationMinusOne(selectedTable,multiply);
        String resultStringA=String.valueOf(resultA);
        optionATextView.setText(resultStringA);
        resultB=appProcesses.randomIntNumberTwo(10,selectedTable);
        String resultStringB=String.valueOf(resultB);
        optionBTextView.setText(resultStringB);
        resultC=appProcesses.multiplicationPlusOne(selectedTable,multiply);
        String resultStringC=String.valueOf(resultC);
        optionCTextView.setText(resultStringC);
        resultD=appProcesses.multiplication(selectedTable,multiply);
        String resultStringD=String.valueOf(resultD);
        optionDTextView.setText(resultStringD);
    }
    public  void correctOption(){
        score++;
        String scoreString=getString(R.string.star_game_mode)+String.valueOf(score);
        textViewScore.setText(scoreString);
        note.setTextColor(Color.GREEN);
        String noteCorrect=getString(R.string.star_game_mode_dos);
        note.setText(noteCorrect);
        cont++;
        delayTime();
    }
    public  void incorrectOption(){
        String scoreString=getString(R.string.star_game_mode)+String.valueOf(score);
        textViewScore.setText(scoreString);
        note.setTextColor(Color.RED);
        String noteCorrect=getString(R.string.star_game_mode_tres);
        note.setText(noteCorrect);
        cont++;
        delayTime();
    }
    public  void nextActivity(){
        Intent intent= new Intent(this,StartHardRandomMode.class);
        intent.putExtra("score",score);
        intent.putExtra("mode",gameMode);
        intent.putExtra("cont", cont);
        startActivity(intent);
    }
    public  void returnActivity(){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void delayTime(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        },1000);

    }
    public  void restartGame(){
        Intent intent= new Intent(this,StartHardRandomMode.class);
        intent.putExtra("score",0);
        intent.putExtra("mode",gameMode);
        intent.putExtra("cont", 0);
        startActivity(intent);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            countDownTimer.cancel();
            AlertDialog.Builder newDialog = new AlertDialog.Builder(StartHardRandomMode.this);
            newDialog.setTitle(getString(R.string.star_game_mode_ocho));
            newDialog.setMessage(getString(R.string.star_game_mode_nueve));
            newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                returnActivity();
                dialogInterface.dismiss();
            });
            newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                countDownTimer.start();
                dialogInterface.cancel();
            });
            newDialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void finish() {
        super.finish();
    }
}