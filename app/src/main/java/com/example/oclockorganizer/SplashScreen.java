package com.example.oclockorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.VideoView;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    VideoView appSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // To display app in full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // To remove the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        // this is for the main splash screen video
        appSplash = (VideoView) findViewById(R.id.splashVideo);
        String splash_path = "android.resource://" + getPackageName() + "/" + R.raw.splash_video;
        Uri videoSplash = Uri.parse(splash_path);
        appSplash.setVideoURI(videoSplash);
        appSplash.start();
        appSplash.setOnCompletionListener(mediaPlayer -> appSplash.start());

        //calling new activity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
            startActivity(intent);
            finish();
        }, 4000);

    }
}