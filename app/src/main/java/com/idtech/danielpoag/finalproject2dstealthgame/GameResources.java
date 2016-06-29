package com.idtech.danielpoag.finalproject2dstealthgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by student on 6/27/2016.
 */
public class GameResources{
    public static Bitmap playerup;
    public static Bitmap playerright;
    public static Bitmap playerleft;
    public static Bitmap playerdown;
    public static Bitmap guardup;
    public static Bitmap guardright;
    public static Bitmap guarddown;
    public static Bitmap guardleft;
    public static Bitmap wall;
    public static Bitmap objectiveactive;
    public static Bitmap objectiveinactive;

    public static void init(Context c){
        playerup = BitmapFactory.decodeResource(c.getResources(), R.drawable.playerup);
        playerright = BitmapFactory.decodeResource(c.getResources(), R.drawable.playerright);
        playerleft = BitmapFactory.decodeResource(c.getResources(), R.drawable.playerleft);
        playerdown = BitmapFactory.decodeResource(c.getResources(), R.drawable.playerdown);
        guardup = BitmapFactory.decodeResource(c.getResources(), R.drawable.guardup);
        guardright = BitmapFactory.decodeResource(c.getResources(), R.drawable.guardright);
        guarddown = BitmapFactory.decodeResource(c.getResources(), R.drawable.guarddown);
        guardleft = BitmapFactory.decodeResource(c.getResources(), R.drawable.guardleft);
        wall = BitmapFactory.decodeResource(c.getResources(), R.drawable.wall);
        objectiveactive = BitmapFactory.decodeResource(c.getResources(), R.drawable.objectiveactive);
        objectiveinactive = BitmapFactory.decodeResource(c.getResources(), R.drawable.objectiveinactive);
    }
}
