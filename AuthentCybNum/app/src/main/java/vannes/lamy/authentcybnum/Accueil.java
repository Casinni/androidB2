package vannes.lamy.authentcybnum;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Accueil extends AppCompatActivity {
TextView bienvenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        //récupérattion de l'intent
        Intent i=getIntent();
        String login=i.getStringExtra("msg");
        //acces au textview pour le message de bienvenue
        bienvenu=findViewById(R.id.bienvenue);
        Log.e("bienvenu",getResources().getString(R.string.bienvenu));
        bienvenu.setText(getResources().getString(R.string.bienvenu)+ " "+ login);
        //demande la permission de téléphoner à l'utilisateur
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},1);
        }
    }
    //on vérifié si la permission a été autorisée
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "permission acceptée", Toast.LENGTH_SHORT).show();
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CALL_PHONE}, 1);
                }
                return;
            }
        }
    }
    public void alarme(View v){
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
        i.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarme ESAIP");
        i.putExtra(AlarmClock.EXTRA_HOUR, 19);
        i.putExtra(AlarmClock.EXTRA_MINUTES, 00);
        startActivity(i);
    }
    public void appel(View v){
        //implementer la méthode pour lancer un appel
        startActivity(new Intent(Intent.ACTION_CALL,
                Uri.parse("tel:0123123456")));
        //implémenter les permissions dans le manifest
        //<uses-permission android:name="android.permission.CALL_PHONE"/>
    }
    public void esaip(View v){
//implémenter la méthode pour lancer le site web lequipe.fr
        //TODO ajouter les permissions Internet dans le manifest
        //<uses-permission android:name="android.permission.INTERNET"/>
        String url = "https://www.esaip.org/";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
    public void musique(View v){
    Intent i =new Intent(Accueil.this, Musique.class);
    startActivity(i);
    }
    public void video(View v){
        Intent i =new Intent(Accueil.this, Video.class);
        startActivity(i);
    }
    public void fermer(View v){
        finish();
    }
    public void flappyBird(View v){
        sendIntent("fb");
    }
    public void puissance4(View v){
        sendIntent("p4");
    }
    public void doodleJump(View v){
        sendIntent("dj");
    }
    public void sendIntent(String msg){
        Intent i= new Intent(getApplicationContext(),Jeux.class);
        i.putExtra("jeu",msg);
        startActivity(i);
    }
}