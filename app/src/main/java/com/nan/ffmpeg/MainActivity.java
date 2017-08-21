package com.nan.ffmpeg;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nan.ffmpeg.utils.VideoPlayer;
import com.nan.ffmpeg.utils.VideoUtils;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_decode;
    private Button btn_decode_audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 0);
        }

        btn_decode = (Button) findViewById(R.id.btn_decode);
        btn_decode_audio = (Button) findViewById(R.id.btn_decode_audio);
        btn_decode.setOnClickListener(this);
        btn_decode_audio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String inputVideo = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + "input.mp4";

        String outputVideo = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + "output_1280x720_yuv420p.yuv";

        String inputAudio = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + "love.mp3";

        String outputAudio = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + "love.pcm";

        switch (v.getId()) {

            case R.id.btn_decode:
                VideoUtils.decode(inputVideo, outputVideo);
                break;
            case R.id.btn_decode_audio:
                VideoUtils.sound(inputAudio, outputAudio);
                break;

        }
    }
}
