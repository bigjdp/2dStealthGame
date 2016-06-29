package com.idtech.danielpoag.finalproject2dstealthgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by student on 6/27/2016.
 */
public class Wall {
    public void draw(Canvas canvas, int x, int y){
        int xCoord = (canvas.getWidth() / 16) * x;
        int yCoord = ((canvas.getHeight() / 10) * y);
        canvas.drawBitmap(GameResources.wall, xCoord, yCoord, null);
    }
}
