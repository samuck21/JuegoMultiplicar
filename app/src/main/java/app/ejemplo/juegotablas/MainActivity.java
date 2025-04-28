package app.ejemplo.juegotablas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton cambiarDeModo=(ImageButton)findViewById(R.id.imageButtonPlay);
        ImageButton cambiarAcercaDE=(ImageButton)findViewById(R.id.imageButtonDetalles);
        ImageButton settings=(ImageButton)findViewById(R.id.imageButtonConfigu);
        ImageButton exit=(ImageButton)findViewById(R.id.imageButtonSalir);
         cambiarDeModo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
           pasarModoDeJuego();
             }
         });
         exit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 salirApp();
             }
         });
         settings.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
             goToSettings();
             }
         });
    }
    public  void pasarModoDeJuego(){
        Intent intent= new Intent(this,ModoDeJuego.class);
        startActivity(intent);
    }
    public void goToSettings(){
        Intent intent = new Intent(this,AppSettings.class);
        startActivity(intent);
    }
    public  void salirApp(){
        AlertDialog.Builder newDialog = new AlertDialog.Builder(MainActivity.this);
        newDialog.setTitle(getString(R.string.salir_app));
        newDialog.setMessage(getString(R.string.salir_app_dos));
        newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            dialogInterface.dismiss();
        });
        newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
            dialogInterface.cancel();
        });
        newDialog.show();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){

            AlertDialog.Builder newDialog = new AlertDialog.Builder(MainActivity.this);
            newDialog.setTitle(getString(R.string.salir_app));
            newDialog.setMessage(getString(R.string.salir_app_dos));
            newDialog.setPositiveButton(getString(R.string.star_game_mode_seis),(dialogInterface, i) -> {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                dialogInterface.dismiss();
            });
            newDialog.setNegativeButton(getString(R.string.star_game_mode_siete),(dialogInterface, i) -> {
                dialogInterface.cancel();
            });
            newDialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}