package com.nan.ffmpeg;

import android.Manifest;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.nan.ffmpeg.utils.VideoPlayer;
import com.nan.ffmpeg.utils.VideoUtils;

import java.io.File;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoPlayer mPlayer;
    private Button btn_play;
    private SurfaceView sv_video;
    private Button btn_play_audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 0);
        }

        sv_video = (SurfaceView) findViewById(R.id.sv_video);
        btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
        btn_play_audio = (Button) findViewById(R.id.btn_play_audio);
        btn_play_audio.setOnClickListener(this);

        mPlayer = new VideoPlayer();
    }


    @Override
    public void onClick(View v) {
        String inputVideo = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + "input.mp4";

        String inputAudio = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + "love.mp3";

        switch (v.getId()) {

            case R.id.btn_play:
                //native方法中传入SurfaceView的Surface对象，在底层进行绘制
                mPlayer.render(inputVideo, sv_video.getHolder().getSurface());
                break;
            case R.id.btn_play_audio:

                mPlayer.play(inputVideo);
                break;

        }
    }
}
