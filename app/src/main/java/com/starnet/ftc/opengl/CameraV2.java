package com.starnet.ftc.opengl;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by muhan on 20-7-9.
 */

public class CameraV2 {

    public CameraV2(Activity activity) {
        mActivity = activity;
        //1.启动Camera线程
        startCameraThread();

        //2.准备Camera，获取cameraId，获取Camera预览大小
        setupCamera();

        //打开Camera
        openCamera();
    }

    public void startCameraThread() {
        mCameraThread = new HandlerThread("CameraThread");
        mCameraThread.start();
        mCameraHandler = new Handler(mCameraThread.getLooper());
    }


}
