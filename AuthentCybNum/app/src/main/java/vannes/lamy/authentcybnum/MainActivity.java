package vannes.lamy.authentcybnum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView login,mdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recuperation des widgets
        login=findViewById(R.id.login);
        mdp=findViewById(R.id.pwd);
    }

    public void effacer(View v){
        //TODO effacer le contenu des champs
        login.setText("");
        mdp.setText("");
    }
    public void fermer(View v){
        finish();
    }
    public void valider(View v){

        if(login.getText().toString().equals(getResources().getString(R.string.loginok)) &&
         mdp.getText().toString().equals(getResources().getString(R.string.pwdok)))
        {
          Intent i=new Intent(MainActivity.this,Accueil.class);
          i.putExtra("msg",login.getText().toString());
          startActivity(i);
        }
        else
            //lancement d'un toast car authentification non ok
            Toast.makeText(MainActivity.this,"Erreur",Toast.LENGTH_SHORT).show();
            this.effacer(v);
    }
}