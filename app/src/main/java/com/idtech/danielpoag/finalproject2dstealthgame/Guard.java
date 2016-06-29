package com.idtech.danielpoag.finalproject2dstealthgame;

import android.graphics.Canvas;

/**
 * Created by student on 6/27/2016.
 */

/*To Do:
* Add guard AI
* Make guards do something when alerted
* Add guard patrol routes
* Add movement*/

public class Guard {
    private boolean alerted = false;
    private boolean isConscious = true;
    private int directionFacing = 1;

    public Guard(){

    }

    public boolean getAlerted(){
        return alerted;
    }

    public void setAlerted(boolean i){
        alerted = i;
    }

    public void setConscious(boolean bool){
        isConscious = bool;
    }

    public boolean getConscious(){
        return isConscious;
    }

    public void setDirectionFacing(int i){
        directionFacing = i;
    }

    public int getDirectionFacing(){
        return directionFacing;
    }

    public void act(){

    }

    public void draw(Canvas canvas, int x, int y){
        int xCoord = (canvas.getWidth() / 16) * x;
        int yCoord = (canvas.getHeight() / 10) * y;
        if (directionFacing == 1){
            canvas.drawBitmap(GameResources.guardup, xCoord, yCoord, null);
        }
        if (directionFacing == 2){
            canvas.drawBitmap(GameResources.guardright, xCoord, yCoord, null);
        }
        if (directionFacing == 3){
            canvas.drawBitmap(GameResources.guarddown, xCoord, yCoord, null);
        }
        if (directionFacing == 4){
            canvas.drawBitmap(GameResources.guardleft, xCoord, yCoord, null);
        }
    }

    void look(int x, int y){
        if (directionFacing == 4){
            for (int i = y; i > 0; i--) {
                if (!(GameView.level.getLevelArray()[i][x] instanceof Wall)) {
                    if (GameView.level.getLevelArray()[i][x] instanceof Player) {
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (x < 100 && !(GameView.level.getLevelArray()[i][x + 1] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x + 1] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (x < 99 && !(GameView.level.getLevelArray()[i][x+2] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x+2] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (x > 0 && !(GameView.level.getLevelArray()[i][x-1] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x-1] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (x > 1 && !(GameView.level.getLevelArray()[i][x -2] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x -2] instanceof Player){
                        alerted = true;
                    }
                }
            }
        }

        else if (directionFacing == 1){
            for (int i = x; i < 100; i++) {
                if (!(GameView.level.getLevelArray()[y][i] instanceof Wall)) {
                    if (GameView.level.getLevelArray()[y][i] instanceof Player) {
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (y < 100 && !(GameView.level.getLevelArray()[y+1][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y+1][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (y < 99 && !(GameView.level.getLevelArray()[y+2][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y+2][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (y > 0 && !(GameView.level.getLevelArray()[y-1][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y-1][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (y > 1 && !(GameView.level.getLevelArray()[y-2][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y-2][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
        }

        else if (directionFacing == 2){
            for (int i = y; i < 100; i++) {
                if (!(GameView.level.getLevelArray()[i][x] instanceof Wall)) {
                    if (GameView.level.getLevelArray()[i][x] instanceof Player) {
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (x < 100 && !(GameView.level.getLevelArray()[i][x+1] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x+1] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (x < 99 && !(GameView.level.getLevelArray()[i][x+2] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x+2] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (x > 0 && !(GameView.level.getLevelArray()[i][x-1] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x-1] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i < 100; i++){
                if (x > 1 && !(GameView.level.getLevelArray()[i][x - 2] instanceof Wall)){
                    if (GameView.level.getLevelArray()[i][x - 2] instanceof Player){
                        alerted = true;
                    }
                }
            }
        }

        else if (directionFacing == 3){
            for (int i = x; i > 0; i--) {
                if (!(GameView.level.getLevelArray()[y][i] instanceof Wall)) {
                    if (GameView.level.getLevelArray()[y][i] instanceof Player) {
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (y < 100 && !(GameView.level.getLevelArray()[y+1][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y+1][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (y < 99 && !(GameView.level.getLevelArray()[y+2][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y+2][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (y > 0 && !(GameView.level.getLevelArray()[y-1][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y-1][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
            for (int i = y; i > 0; i--){
                if (y > 1 && !(GameView.level.getLevelArray()[y-2][i] instanceof Wall)){
                    if (GameView.level.getLevelArray()[y-2][i] instanceof Player){
                        alerted = true;
                    }
                }
            }
        }
    }
}
