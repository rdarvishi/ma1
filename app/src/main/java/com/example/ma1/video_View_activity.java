package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class video_View_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video__view_activity);

        VideoView videoView = findViewById(R.id.videoView);
         videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.demovideo);
        MediaController vController = new MediaController(this);
        vController.setAnchorView(videoView);
        videoView.setMediaController(vController);
         videoView.start();
    }
}
