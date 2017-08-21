package com.nan.ffmpeg;

import android.Manifest;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.nan.ffmpeg.utils.FFmpegUtils;

import java.io.File;

public class PushActivity extends AppCompatActivity {

    private EditText et_input;
    private EditText et_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        et_input = (EditText) this.findViewById(R.id.et_input);
        et_output = (EditText) this.findViewById(R.id.et_output);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 0);
        }
    }

    public void mStart(View btn) {
        String inputurl = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar
                + et_input.getText().toString();
        String outputurl = et_output.getText().toString();

        //开始推流
        FFmpegUtils.push(inputurl, outputurl);
    }
}
