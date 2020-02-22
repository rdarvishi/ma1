package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Audio_Activity extends AppCompatActivity implements View.OnClickListener {
    Button btn_play, btn_puse;
    MediaPlayer mPlayer;
    SeekBar seekBar_VolumeBar, music_bar;
    TextView tv_seek ;
    AudioManager audioManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_);


        btn_play = findViewById(R.id.play_id);
        btn_puse = findViewById(R.id.puse_id);

        btn_play.setOnClickListener(this);
        btn_puse.setOnClickListener(this);

        tv_seek = findViewById(R.id.TV_volume);
        mPlayer = MediaPlayer.create(this, R.raw.music);

        seekBar_VolumeBar = findViewById(R.id.Volume_bar);



//        seekBar_VolumeBar.setMax(100);
//        seekBar_VolumeBar.setProgress(30);

        VolumeBar();





//audio manager
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int max_volume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int corect_vlume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar_VolumeBar.setMax(max_volume);
        seekBar_VolumeBar.setProgress(corect_vlume);

        music_bar = findViewById(R.id.Seek_music_bar);
        music_bar.setMax(mPlayer.getDuration());
        music_bar.setProgress(0);

        MusicBar();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                music_bar.setProgress(mPlayer.getCurrentPosition());

            }
        },0,100);
    }

    private void MusicBar() {
        music_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (mPlayer!=null && fromUser){
                mPlayer.seekTo(progress);
            }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void VolumeBar() {
        seekBar_VolumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play_id:
                if (!mPlayer.isPlaying()) {
                    mPlayer.start();
                    btn_play.setText("pause");

                } else {
                    mPlayer.pause();
                    btn_play.setText("play");
                }



                break;
            case R.id.puse_id:
                btn_puse.setBackgroundColor(Color.RED);
                break;
            default:
                break;
        }
    }
}
