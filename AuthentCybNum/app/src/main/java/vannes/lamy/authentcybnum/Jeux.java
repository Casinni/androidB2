package vannes.lamy.authentcybnum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Jeux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);
        //recuperation intent
        Intent i=getIntent();
        String games=i.getStringExtra("jeu");
        //recup de la webview
        WebView wb=findViewById(R.id.webView);
        //activation du javascript
        WebSettings webSettings=wb.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if(games.equals("dj")){
            wb.loadUrl("file:///android_asset/doodleJump/index.html");
        }
        else if(games.equals("fb")){
            wb.loadUrl("file:///android_asset/flappyBird/index.html");
        }
        else {
            wb.loadUrl("file:///android_asset/puissance4/index.html");
        }
    }
}