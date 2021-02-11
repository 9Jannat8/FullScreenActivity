package com.example.fullscreenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.fullscreenactivity.R;

public class MainActivity extends AppCompatActivity {//full screen korar jonno themes a jete hobe and noActionBar dite  hobe

    int progress;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove the notification bar

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarId);

        Thread thread = new Thread(new Runnable() {//nirdisto somoy por por progress er value change howar jonno a method
            @Override
            public void run() {

                doWork();
            }
        });

        thread.start();
    }

    //style="@android:style/Widget.ProgressBar.Horizontal" ata progressbar er height change korte help korbe..xml file a

    public void doWork() {//likhte hobe Thread.sleep(1000); tarpor alt + enter caple surround with try/catch a nite hobe..
        for(progress = 20; progress <= 100; progress+=20) {
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}