package com.example.humraz.fire;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    private Preference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
             //   WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
     ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.hide();

        }
        setContentView(R.layout.activity_splash);

        StartAnimations();
    }

    private void HomeScreen(){
            pref.setFirstTimeLaunch(false);
            startActivity(new Intent(SplashActivity.this,SharedActivity.class));
            finish();

        }


        private void StartAnimations() {

            pref = new Preference(SplashActivity.this);

            new CountDownTimer(4000,1000){
                @Override
                public void onTick(long millisUntilFinished)
                {

                }
                @Override
                public void onFinish(){



                    if (pref.isFirstTimeLaunch()) {
                        HomeScreen();
                        SplashActivity.this.finish();
                    }
                    else{
                        startActivity(new Intent(SplashActivity.this, SharedActivity.class).setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
                        SplashActivity.this.finish();
                    }
                }
            }.start();




        }

}
