package com.idtech.danielpoag.finalproject2dstealthgame;

import android.graphics.Canvas;

public class Objective {
    public boolean activated;

    public Objective(){
        activated = false;
    }

    public void draw(Canvas canvas, int x, int y){
        int xCoord = (canvas.getWidth() / 16) * x;
        int yCoord = (canvas.getHeight() / 10) * y;
        if (activated == true){
            canvas.drawBitmap(GameResources.objectiveactive, xCoord, yCoord, null);
        }
        else{
            canvas.drawBitmap(GameResources.objectiveinactive, xCoord, yCoord, null);
        }
    }
}
