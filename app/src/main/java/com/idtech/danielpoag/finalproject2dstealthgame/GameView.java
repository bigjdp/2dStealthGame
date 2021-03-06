package com.idtech.danielpoag.finalproject2dstealthgame;

/**
 * Created by student on 6/27/2016.
 */

/*To Do:
* Add clearing of undrawn things: DONE I THINK*/

import android.content.Context;
        import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
        import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private GameThread thread;
    public static Level level = new Level();
    public Paint myPaint = new Paint();
    public static boolean win = false;

    Boolean[] objectivesActivated = {false, false, false};

    public GameView(Context context) {
        super(context);
        getHolder().addCallback(this);

        myPaint.setColor(Color.rgb(255, 255, 255));
        myPaint.setStrokeWidth(10);
        myPaint.setStyle(Paint.Style.STROKE);

        thread = new GameThread(getHolder(), this);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        /*boolean retry = true;
        while(retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
            }
        }*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        //System.out.println("Touch");
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (int x = 0; x < 15; x++){
                for (int y = 0; y < 10; y++){
                    if (Screen.screenQuadrants[y][x].contains((int)touchX,(int)touchY)){
                        Player.move(x, y);
                        System.out.println(x + "," + y);
                    }
                }
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        if (win){
            winner();
        }
        Screen.screenUpdate();
        System.out.println("Player is visually at: " + Player.visiblePlayerX + "," + Player.visiblePlayerY);
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 15; x++){
                if (Screen.visibleScreen[y][x] instanceof Player){
                    ((Player)Screen.visibleScreen[y][x]).draw(canvas, x, y);
                }
                else if (Screen.visibleScreen[y][x] instanceof Wall){
                    ((Wall)Screen.visibleScreen[y][x]).draw(canvas, x, y);
                }
                else if (Screen.visibleScreen[y][x] instanceof Guard){
                    ((Guard)Screen.visibleScreen[y][x]).draw(canvas, x, y);
                }
                else if (Screen.visibleScreen[y][x] instanceof Objective){
                    ((Objective)Screen.visibleScreen[y][x]).draw(canvas, x, y);
                }
            }
        }
        for (int y = 0; y < 10; y++){
            for (int x = 0; x < 15; x++){
                canvas.drawRect(Screen.screenQuadrants[y][x], myPaint);
            }
        }
    }

    private void winner(){
        thread.setRunning(false);
    }

}

