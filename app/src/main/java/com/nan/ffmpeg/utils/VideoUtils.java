package com.nan.ffmpeg.utils;

/**
 * Created by wuhuannan on 17-3-31.
 */

public class VideoUtils {

    //视频解码
    public native static void decode(String input, String outptu);

    //音频解码
    public native static void sound(String input,String output);
}
