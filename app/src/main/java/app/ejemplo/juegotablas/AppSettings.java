package app.ejemplo.juegotablas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);
        Button modeS=(Button)findViewById(R.id.button);
        Button modeR=(Button)findViewById(R.id.button2);
        Button modeRH=(Button)findViewById(R.id.button3);
        Button modeA=(Button)findViewById(R.id.button4);
        SharedPreferences preferences = getSharedPreferences("score", Context.MODE_PRIVATE);
        SharedPreferences.Editor Ob=preferences.edit();
        modeS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder newDialog = new AlertDialog.Builder(AppSettings.this);
                newDialog.setTitle(getString(R.string.appsettings_cinco));
                newDialog.setMessage(getString(R.string.appsettings_seis));
                newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                    Ob.putInt("scoreTableOne",0);
                    Ob.putInt("scoreTableTwo",0);
                    Ob.putInt("scoreTableThree",0);
                    Ob.putInt("scoreTableFour",0);
                    Ob.putInt("scoreTableFive",0);
                    Ob.putInt("scoreTableSix",0);
                    Ob.putInt("scoreTableSeven",0);
                    Ob.putInt("scoreTableEigth",0);
                    Ob.putInt("scoreTableNine",0);
                    Ob.putInt("scoreTableTen",0);
                    Ob.commit();
                    dialogInterface.dismiss();
                });
                newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
                newDialog.show();
            }
        });
        modeR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder newDialog = new AlertDialog.Builder(AppSettings.this);
                newDialog.setTitle(getString(R.string.appsettings_cinco));
                newDialog.setMessage(getString(R.string.appsettings_seis));
                newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                    Ob.putInt("scoreTableOneR",0);
                    Ob.putInt("scoreTableTwoR",0);
                    Ob.putInt("scoreTableThreeR",0);
                    Ob.putInt("scoreTableFourR",0);
                    Ob.putInt("scoreTableFiveR",0);
                    Ob.putInt("scoreTableSixR",0);
                    Ob.putInt("scoreTableSevenR",0);
                    Ob.putInt("scoreTableEigthR",0);
                    Ob.putInt("scoreTableNineR",0);
                    Ob.putInt("scoreTableTenR",0);
                    Ob.commit();
                    dialogInterface.dismiss();
                });
                newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
                newDialog.show();
            }
        });
        modeRH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder newDialog = new AlertDialog.Builder(AppSettings.this);
                newDialog.setTitle(getString(R.string.appsettings_cinco));
                newDialog.setMessage(getString(R.string.appsettings_seis));
                newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                    Ob.putInt("scoreOne",0);
                    Ob.putInt("scoreTwo",0);
                    Ob.putInt("scoreTree",0);
                    Ob.commit();
                    dialogInterface.dismiss();
                });
                newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
                newDialog.show();
            }
        });
        modeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder newDialog = new AlertDialog.Builder(AppSettings.this);
                newDialog.setTitle(getString(R.string.appsettings_cinco));
                newDialog.setMessage(getString(R.string.appsettings_seis));
                newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                    Ob.putInt("scoreTableOne",0);
                    Ob.putInt("scoreTableTwo",0);
                    Ob.putInt("scoreTableThree",0);
                    Ob.putInt("scoreTableFour",0);
                    Ob.putInt("scoreTableFive",0);
                    Ob.putInt("scoreTableSix",0);
                    Ob.putInt("scoreTableSeven",0);
                    Ob.putInt("scoreTableEigth",0);
                    Ob.putInt("scoreTableNine",0);
                    Ob.putInt("scoreTableTen",0);
                    Ob.putInt("scoreTableOneR",0);
                    Ob.putInt("scoreTableTwoR",0);
                    Ob.putInt("scoreTableThreeR",0);
                    Ob.putInt("scoreTableFourR",0);
                    Ob.putInt("scoreTableFiveR",0);
                    Ob.putInt("scoreTableSixR",0);
                    Ob.putInt("scoreTableSevenR",0);
                    Ob.putInt("scoreTableEigthR",0);
                    Ob.putInt("scoreTableNineR",0);
                    Ob.putInt("scoreTableTenR",0);
                    Ob.putInt("scoreOne",0);
                    Ob.putInt("scoreTwo",0);
                    Ob.putInt("scoreTree",0);
                    Ob.commit();
                    dialogInterface.dismiss();
                });
                newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                    dialogInterface.cancel();
                });
                newDialog.show();
            }
        });

    }
}