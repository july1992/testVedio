package com.vily.testvedio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private VideoView mVideo_view;
    private Button mBtn_start;
    private Button mBtn_pause;
    private Button mBtn_seek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideo_view = findViewById(R.id.video_view);

        mBtn_start = findViewById(R.id.btn_start);
        mBtn_pause = findViewById(R.id.btn_pause);
        mBtn_seek = findViewById(R.id.btn_seek);

        final String videoPath = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.test).toString();

        mVideo_view.setVideoPath(videoPath);

        mVideo_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(false);

            }
        });

        mVideo_view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });

        mBtn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String path=Environment.getExternalStorageDirectory().getAbsolutePath()+"/60.mp4";
//                File file=new File(path);
                mVideo_view.start();

            }
        });

        mBtn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideo_view.pause();
            }
        });

        mBtn_seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideo_view.seekTo(3000);
            }
        });
    }
}
