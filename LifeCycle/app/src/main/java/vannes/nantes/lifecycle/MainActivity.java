package vannes.nantes.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    //definition du nom du tag pour loguer les evenements ->nom de la classe
    private final String TAG="ActivitePrincipale";
    @Override
    //Called when the activity is first created
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "OnCreate" );
    }
    //The final call you receive before your activity is destroyed.
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"OnDestroy");
    }
    //Called when the system is about to start resuming a previous activity
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"OnPause");
    }
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"OnStop");
    }
    //Called when the activity will start interacting with the user
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"OnResume");
    }
    //This method is called before an activity may be killed so that when it comes back some time in the future it can restore its state.
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"OnsaveInstanceState");
    }
    //This method is called after onStart() when the activity is being re-initialized from a previously saved state
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "OnRestoreInstanceState");
    }
    //Called when the activity will start interacting with the user
    protected void onRestart() {
        super.onRestart();

        Log.i(TAG, "OnRestart");
    }
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }
}