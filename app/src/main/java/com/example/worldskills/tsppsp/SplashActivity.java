package com.example.worldskills.tsppsp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //decorar vista
        View decorar = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorar.setSystemUiVisibility(uiOptions);

// creamos un salto de vista de 2 segundos al menu activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent inicio = new Intent(SplashActivity.this, MenuActivity.class);
                startActivity(inicio);
                finish();


            }
        }, 2000);
    }
}
