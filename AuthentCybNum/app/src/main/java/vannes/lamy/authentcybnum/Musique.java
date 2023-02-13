package vannes.lamy.authentcybnum;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Musique extends AppCompatActivity {
MediaPlayer mp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musique);
}
    public void stop (View v){
        //on arrête et on vide les ressouces du player
         mp1.stop();
         mp1.release();
         mp1=null;
    }
    public void start (View v){
        if(mp1!=null && mp1.isPlaying()){
            //si la lecture est deja en cours on relance la
            // la  lecture au début
            mp1.seekTo(0);
        }
        else
        {
            mp1 = MediaPlayer.create(Musique.this, R.raw.song);
            mp1.start();
        }
    }
    public void fermer(View v){
        finish();
    }

}