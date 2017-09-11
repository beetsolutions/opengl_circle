package com.beetsolutions.opengl.circle;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class GLRenderer implements GLSurfaceView.Renderer {

    private static final float X_POSITION = 0.5f;
    private static final float Y_POSITION = 0.5f;

    private static float YELLOW_COLOR[] = {0.976f, 0.694f, 0.015f, 1f};
    private GLCircleSprite mSprite;

    @Override
    public void onSurfaceCreated(GL10 glUnused, EGLConfig config) {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 0.5f);
        mSprite = new GLCircleSprite(YELLOW_COLOR);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);

        float mainBlobX = width * X_POSITION;
        float mainBlobY = height * Y_POSITION;

        mSprite.setCenterX(mainBlobX);
        mSprite.setCenterY(mainBlobY);
        mSprite.setRadius(200);
    }

    @Override
    public void onDrawFrame(GL10 glUnused) {
        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
        mSprite.draw();
    }
}
