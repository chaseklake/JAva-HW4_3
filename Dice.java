package com.chaseklake.yahtzee;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import java.util.Random;

import com.chaseklake.yahtzee.MainActivity;
import com.chaseklake.yahtzee.R;

/**
 * Created by Chase Lake on 1/20/2017.
 */

public class Dice implements Runnable {
    private static final int ONE = R.drawable.one;
    private static final int TWO = R.drawable.two;
    private static final int THREE = R.drawable.three;
    private static final int FOUR = R.drawable.four;
    private static final int FIVE = R.drawable.five;
    private static final int SIX = R.drawable.six;

    ImageView face;
    int value;
    Random rand = new Random();
    Context m;
    Handler mainHandler;

    Dice (ImageView iv, Context m) {
        face = iv;
        this.m = m;
        roll();
    }

    public void roll() {
        mainHandler = new Handler(m.getMainLooper());
        Runnable runnable = new Runnable() {
            public void run() {
                int next = rand.nextInt(6) + 1;
                value = next;
                switch(next) {
                    case 1:
                        face.setImageResource(ONE);
                        break;

                    case 2:
                        face.setImageResource(TWO);
                        break;

                    case 3:
                        face.setImageResource(THREE);
                        break;

                    case 4:
                        face.setImageResource(FOUR);
                        break;

                    case 5:
                        face.setImageResource(FIVE);
                        break;

                    case 6:
                        face.setImageResource(SIX);
                        break;
                }
            }
        };
        mainHandler.post(runnable);
    }

    public void run() {
        int timer = rand.nextInt(300) + 1;
        for (int i = 0; i < timer; i++) {
            this.roll();
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException ex) {;}
        }
    }
}
