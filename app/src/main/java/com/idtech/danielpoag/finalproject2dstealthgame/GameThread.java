package com.idtech.danielpoag.finalproject2dstealthgame;

/**
 * Created by student on 6/27/2016.
 */
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    private SurfaceHolder surfaceHolder;
    private GameView gameView;

    private boolean running;
    public void setRunning(boolean running) {
        this.running = running;
    }

    public GameThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    @SuppressLint("WrongCall")
    public void run() {
        Canvas canvas;
        while (running) {
            canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                //GameResources.screenHeight = canvas.getHeight();
                //GameResources.screenWidth = canvas.getWidth();
                synchronized (surfaceHolder) {
                    this.gameView.onDraw(canvas);
                }
            }
            finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
