package com.starnet.ftc.opengl.filter;

/**
 * Created by muhan on 20-7-9.
 */

import android.content.Context;

/**
 * 没有滤镜效果
 */
public class Camera2FilterNone extends Camera2BaseFilter {

    public Camera2FilterNone(Context context, int textureId) {
        super(context, textureId);
    }

    @Override
    protected ShaderManager.Param getProgram() {
        return ShaderManager.getParam(ShaderManager.CAMERA_BASE_SHADER);
    }
}
