package com.idtech.danielpoag.finalproject2dstealthgame;

import android.graphics.Rect;

/**
 * Created by student on 6/28/2016.
 */
public class Screen {
    public static Rect[][] screenQuadrants = new Rect[10][15];
    public static Object[][] visibleScreen = new Object[10][15];

    public Screen() {
        /*try{
            Thread.sleep(3);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }*/
        System.out.println("Rectangles");
        System.out.println("" + GameResources.screenWidth);
        System.out.println("" + GameResources.screenHeight);
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 10; y++) {
                screenQuadrants[y][x] = new Rect(
                        x * GameResources.screenWidth / 15,
                        y * GameResources.screenHeight / 10,
                        (1 + x) * GameResources.screenWidth / 15,
                        (1 + y) * GameResources.screenHeight / 10);
            }
        }
    }

    public void screenUpdate() {
        for (int y = 0; y < 99; y++) {
            for (int x = 0; x < 99; x++) {
                if (GameView.level.getLevelArray()[y][x] instanceof Player) {
                    Player.playerY = y;
                    Player.playerX = x;
                }
            }
        }
        int indexX;
        int indexY = 0;
        for (int y = (Player.playerY - 5); y < (Player.playerY + 5); y++) {
            indexX = 0;
            for (int x = (Player.playerX - 7); x < (Player.playerX + 8); x++){
                visibleScreen[indexY][indexX] = GameView.level.getLevelArray()[y][x];
                indexX++;
            }
            indexY++;
        }
        int objectivesActivated = 0;
        for (int yIterator = 0; yIterator < 99; yIterator++){
            for (int xIterator = 0; xIterator < 99; xIterator++){
                if (GameView.level.getLevelArray()[yIterator][xIterator] instanceof Objective){
                    if (Player.playerX - xIterator < 2 && Player.playerY - yIterator < 2){
                        ((Objective)GameView.level.getLevelArray()[yIterator][xIterator]).activated = true;
                        objectivesActivated++;
                    }
                }

                else if (GameView.level.getLevelArray()[yIterator][xIterator] instanceof Guard){
                    ((Guard)GameView.level.getLevelArray()[yIterator][xIterator]).act();
                }

                if (objectivesActivated > 2){
                    GameView.win = true;
                }
            }
        }

        for (int x = 0; x < 15; x++){
            for (int y = 0; y < 10; y++){
                if (visibleScreen[y][x] instanceof Player){
                    Player.visiblePlayerX = x;
                    Player.visiblePlayerY = y;
                }
            }
        }
    }
}
