package com.example.video;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;

    DisplayManager displayManager;
    Display[] presentationDisplays;

    private static Handler vHandler;

    int videocount = 0;

    String [] videopath = { "/storage/emulated/0/a/Video/beef.mp4", "/storage/emulated/0/a/Video/pizza.mp4", "/storage/emulated/0/a/Video/fried.mp4"};

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("",""+videopath.length);

        displayManager = (DisplayManager) getApplicationContext().getSystemService(Context.DISPLAY_SERVICE);
        presentationDisplays = displayManager.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION);
        LayoutInflater inflate = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

        video = findViewById(R.id.video);

        video.setVideoPath(videopath[videocount]);
        video.start();

        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(videocount==videopath.length-1){
                    videocount = 0;
                }else {
                    videocount++;

                }
                video.stopPlayback();
                video.setVideoPath(videopath[videocount]);
                video.start();





//                switch(videocount) {
//                    case 0:
//                        videocount = 1;
//                        video.stopPlayback();
//                        video.setVideoPath(videopath[1]);
//                        video.start();
//                        break;
//                    case 1:
//                        videocount = 2;
//                        video.stopPlayback();
//                        video.setVideoPath(videopath[2]);
//                        video.start();
//                        break;
//                    case 2:
//                        videocount = 0;
//                        video.stopPlayback();
//                        video.setVideoPath(videopath[0]);
//                        video.start();
//                        break;
//
//                }





            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("",""+videopath.length);

    }
}