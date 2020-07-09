package com.starnet.ftc.opengl;

import android.opengl.GLSurfaceView;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        GLSurfaceView glSurfaceView = new GLSurfaceView(this);
//        glSurfaceView.setRenderer(new MyGLRenderer());
//        setContentView(glSurfaceView);
//    }


    private static final String TAG = "Camera2Demo_SurfaceView";

    private GLSurfaceView mCameraV2GLSurfaceView;
    private CameraV2Renderer mCameraV2Renderer;
    private CameraV2 mCamera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera2_surfaceview_activity);
        initView();
    }

    private void initView() {
        //Camera2 API 进行封装
        mCamera = new CameraV2(this);

        mCameraV2GLSurfaceView = findViewById(R.id.glsurfaceview);
        mCameraV2GLSurfaceView.setEGLContextClientVersion(2);

        mCameraV2Renderer = new CameraV2Renderer();
        mCameraV2Renderer.init(mCameraV2GLSurfaceView, mCamera, this);
        mCameraV2GLSurfaceView.setRenderer(mCameraV2Renderer);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCamera != null) {
            mCamera.closeCamea();
        }
    }

    public void takePicture(View view) {
        Log.d(TAG, "onclick takePicture: ");
    }
}
