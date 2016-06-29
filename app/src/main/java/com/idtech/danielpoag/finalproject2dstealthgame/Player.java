package com.idtech.danielpoag.finalproject2dstealthgame;

import android.graphics.Canvas;

/*
    @TODO knockout checking
*/

public class Player {
    private static int directionFacing = 4;
    public static int playerX = 50;
    public static int playerY = 50;
    public static int visiblePlayerX = 7;
    public static int visiblePlayerY = 4;

    public static void move(int xTouched, int yTouched){
        knockOutCheck();
        //MAKE IT NOT GO THROUGH WALLS.
        if (Math.abs((yTouched - 5)) < Math.abs((xTouched - 7))){
            if (playerX > playerX + xTouched - 7){
                setDirectionFacing(4);
                for (int x = playerX; x >= playerX + xTouched - 7; x--){
                    if (GameView.level.getLevelArray()[playerY][x] instanceof Wall){
                        return;
                    }
                }
                if (GameView.level.getLevelArray()[playerY][playerX + xTouched - 7] != null){
                    return;
                }
            }
            else{
                setDirectionFacing(2);
                for (int x = playerX; x <= playerX + xTouched - 7; x++){
                    if (GameView.level.getLevelArray()[playerY][x] instanceof Wall){
                        return;
                    }
                }
                if (GameView.level.getLevelArray()[playerY][playerX + xTouched - 7] != null){
                    return;
                }
            }
            GameView.level.setLevelArray(playerX, playerY, null);
            GameView.level.setLevelArray(playerX + xTouched - 7, playerY, new Player());
            Screen.screenUpdate();
            System.out.println("Player Moved");
        }
        else if (Math.abs((yTouched - 5)) > Math.abs((xTouched - 7))){
            int oldY = playerY;
            if (oldY < playerY + yTouched - 5){
                setDirectionFacing(3);
                for (int y = playerY; y <= playerY + yTouched - 5; y++){
                    if (GameView.level.getLevelArray()[y][playerX] instanceof Wall){
                        return;
                    }
                }
                if (GameView.level.getLevelArray()[playerY + yTouched - 5][playerX] != null){
                    return;
                }
                GameView.level.setLevelArray(playerX, playerY, null);
                GameView.level.setLevelArray(playerX, playerY + yTouched - 5, new Player());
                System.out.println("Player Moved");
            }
            else{
                setDirectionFacing(1);
                for (int y = playerY; y >= playerY + yTouched - 5; y--){
                    if (GameView.level.getLevelArray()[y][playerX] instanceof Wall){
                        return;
                    }
                }
                if (GameView.level.getLevelArray()[playerY + yTouched - 5][playerX] != null){
                    return;
                }
                GameView.level.setLevelArray(playerX, playerY, null);
                GameView.level.setLevelArray(playerX, playerY + yTouched - 5, new Player());
            }
            Screen.screenUpdate();
        }

        System.out.println("" + playerX + "," + playerY);
    }

    public static void knockOutCheck(){

    }

    public static int getDirectionFacing() {
        return directionFacing;
    }

    public static void setDirectionFacing(int dir) {
        directionFacing = dir;
    }

    public void draw(Canvas canvas, int x, int y){
        int xCoord = (canvas.getWidth() / 16) * x;
        int yCoord = (canvas.getHeight() / 10) * y;
        if (directionFacing == 1){
            canvas.drawBitmap(GameResources.playerup, xCoord, yCoord, null);
        }
        if (directionFacing == 2){
            canvas.drawBitmap(GameResources.playerright, xCoord, yCoord, null);
        }
        if (directionFacing == 3){
            canvas.drawBitmap(GameResources.playerdown, xCoord, yCoord, null);
        }
        if (directionFacing == 4){
            canvas.drawBitmap(GameResources.playerleft, xCoord, yCoord, null);
        }
    }
}
