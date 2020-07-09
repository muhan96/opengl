package com.starnet.ftc.opengl.util;

import android.opengl.GLES20;
import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/**
 * Created by muhan on 20-7-9.
 */

public class GLUtil {

    public static int loadShader(int shaderType, String source) {
        // 创造顶点着色器类型(GLES20.GL_VERTEX_SHADER)
        // 或者是片段着色器类型 (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(shaderType);
        // 添加上面编写的着色器代码并编译它
        GLES20.glShaderSource(shader, source);
        GLES20.glCompileShader(shader);
        //存放编译成功Shader数量数组
        int[] compileStatus = new int[1];
        //获取shader编译情况
        GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compileStatus, 0);
        if(compileStatus[0] == 0){
            //编译失败，显示日志并删除该对象
            Log.e("GLUtil", "Could not compile shader " + shaderType + ":");
            Log.e("GLUtil", GLES20.glGetShaderInfoLog(shader));
            GLES20.glDeleteShader(shader);
            return 0;
        }
        return shader;
    }

    /**
     * float 数组转换成FloatBuffer，OpenGL才能使用
     * @param arr
     * @return
     */
    public static FloatBuffer floatArray2FloatBuffer(float[] arr)
    {
        FloatBuffer mBuffer;
        // 初始化ByteBuffer，长度为arr数组的长度*4，因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        // 数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asFloatBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);
        return mBuffer;
    }


    public static ShortBuffer shortArray2ShortBuffer(short[] index) {
        ShortBuffer mBuffer;
        ByteBuffer qbb = ByteBuffer.allocateDirect(index.length * 4);
        qbb.order(ByteOrder.nativeOrder());
        mBuffer = qbb.asShortBuffer();
        mBuffer.put(index);
        mBuffer.position(0);
        return mBuffer;
    }

    public static int getOESTextureId() {
    }
}
