package vannes.lamy.authentcybnum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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
}