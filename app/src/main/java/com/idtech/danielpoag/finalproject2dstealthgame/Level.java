package com.idtech.danielpoag.finalproject2dstealthgame;


/**
 * Created by student on 6/27/2016.
 */

/*To Do:
* Add level generation
* Add objectives to level generation*/

public class Level {

    private static Object levelArray[][] = new Object[100][100];
    public Level(){
        //Add level generation here. Place guards, Walls, objectives, and the player.
        setLevelRect(0,0,99,99,new Wall());
        setLevelRect(47, 47, 53, 53, null);
        setLevelArray(52, 52, new Wall());
        setLevelArray(50, 50, GameView.player);



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
