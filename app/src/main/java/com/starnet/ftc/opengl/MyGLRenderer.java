package com.starnet.ftc.opengl;

import android.opengl.EGLConfig;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;


import com.starnet.ftc.opengl.util.Square;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by muhan on 20-7-8.
 */

public class MyGLRenderer implements GLSurfaceView.Renderer {
    private GLTriangle mGlTriangle;
    private Square mSquare;
    private String TAG = "renderer";

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        // 设置个红色背景
        GLES20.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
    }

    public void onDrawFrame(GL10 unused) {
//        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        // Redraw background color 重绘背景
        mSquare.draw();
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, javax.microedition.khronos.egl.EGLConfig eglConfig) {
        mSquare = new Square();
        Log.d(TAG,"create success");
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        // 设置绘图的窗口(可以理解成在画布上划出一块区域来画图)
        GLES20.glViewport(100,100,width,height);
    }
}



