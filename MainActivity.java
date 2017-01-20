package com.chaseklake.yahtzee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public Dice[] dice = new Dice[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button roll = (Button) this.findViewById(R.id.button);
        ImageView one = (ImageView) this.findViewById(R.id.imageView);
        ImageView two = (ImageView) this.findViewById(R.id.imageView2);
        ImageView three = (ImageView) this.findViewById(R.id.imageView3);
        ImageView four = (ImageView) this.findViewById(R.id.imageView4);
        ImageView five = (ImageView) this.findViewById(R.id.imageView5);
        dice[0] = new Dice(one, this);
        dice[1] = new Dice(two, this);
        dice[2] = new Dice(three, this);
        dice[3] = new Dice(four, this);
        dice[4] = new Dice(five, this);

        roll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread[] t = new Thread[5];
                for (int i = 0; i < 5; i++) {
                    t[i] = new Thread(dice[i]);
                    t[i].start();
                }
            }
        });
    }
}
