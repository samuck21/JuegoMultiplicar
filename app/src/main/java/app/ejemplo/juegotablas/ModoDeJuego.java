package app.ejemplo.juegotablas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ModoDeJuego extends AppCompatActivity {
private  String gameMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_de_juego);
        ImageButton successiveMode=(ImageButton)findViewById(R.id.imageButtonSucesivo);
        ImageButton randomMode=(ImageButton)findViewById(R.id.imageButton2);
        ImageButton hardRandomMode=(ImageButton)findViewById(R.id.imageButton3);


        successiveMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeSuccessiveMode();
            }
        });
        randomMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeRandomMode();
            }
        });
        hardRandomMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               changeRandomModeHard();
            }
        });
    }
    public void changeHardRandomMode(){

    }
    public void changeSuccessiveMode(){
        gameMode="modeS";
        Intent intent = new Intent(this,SeleccionTabla.class);
        intent.putExtra("mode",gameMode);
        startActivity(intent);
    }
   public void changeRandomMode(){
       gameMode="modeR";
       Intent intent = new Intent(this,SeleccionTabla.class);
       intent.putExtra("mode",gameMode);
       startActivity(intent);

   }
    public void changeRandomModeHard(){
        gameMode="modeRH";
        Intent intent = new Intent(this,HardRandom.class);
        intent.putExtra("mode",gameMode);
        startActivity(intent);

    }
}