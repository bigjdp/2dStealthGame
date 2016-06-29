package com.idtech.danielpoag.finalproject2dstealthgame;


import java.util.Random;

/**
 * Created by student on 6/27/2016.
 */

/*To Do:
* Add level generation
* Add objectives to level generation*/

public class Level {

    private static Object levelArray[][] = new Object[100][100];
    Random random = new Random();

    public Level(){
        //Add level generation here. Place guards, Walls, objectives, and the player.
        setLevelRect(0,0,99,99,new Wall());
        setLevelRect(47, 47, 53, 53, null);
        setLevelArray(50, 50, GameView.player);
        for (int x = 14; x < 84; x++){
                for (int y = 14; y < 84; y++){
                    if (levelArray[y][x] == null && levelArray[y][x + 3] instanceof Wall){
                        setLevelRect(x, y, (x + random.nextInt(5)), (y + random.nextInt(5)), null);
                    }
                    if (levelArray[y][x] == null && levelArray[y][x - 3] instanceof Wall){
                        setLevelRect(x, y, (x + random.nextInt(5)), (y + random.nextInt(5)), null);
                    }
                    if (levelArray[y][x] == null && levelArray[y + 3][x] instanceof Wall){
                        setLevelRect(x, y, (x + random.nextInt(5)), (y + random.nextInt(5)), null);
                    }
                    if (levelArray[y][x] == null && levelArray[y - 3][x] instanceof Wall){
                        setLevelRect(x, y, (x + random.nextInt(5)), (y + random.nextInt(5)), null);
                    }
                }
        }


    }

    public void setLevelArray(int x, int y, Object o){
        levelArray[y][x] = o;
    }

    public void setLevelRect(int topLeftX,
                             int topLeftY,
                             int bottomRightX,
                             int bottomRightY, Object o){
        for (int x = topLeftX; x <= bottomRightX; x++){
            for (int y = topLeftY; y <= bottomRightY; y++){
                setLevelArray(x, y, o);
            }
        }
    }

    public Object[][] getLevelArray(){
        return levelArray;
    }
}
