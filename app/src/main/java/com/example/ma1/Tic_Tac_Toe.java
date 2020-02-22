package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Tic_Tac_Toe extends AppCompatActivity {


    public static final int Red_code = 0 ;
    public static final int yellow_code = 1 ;
    public static final int Not_play = 2 ;

    int active_player = Red_code ;

    int [] gameState ={Not_play , Not_play , Not_play,
                    Not_play , Not_play , Not_play,
                    Not_play , Not_play , Not_play};

    int[][] wining_positoin = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic__tac__toe);
    }

    public void dropIn(View view) {

        int tag = Integer.parseInt((String) view.getTag()) ;

         if (gameState[tag]!=Not_play){
             return;
         }
        ImageView im = (ImageView) view;
        im.setTranslationY(-1000f);
        if (active_player== Red_code){
            im.setImageResource(R.drawable.red);
            gameState[tag]=Red_code ;

            active_player= yellow_code ;

        }else
            if (active_player== yellow_code){
                im.setImageResource(R.drawable.yello);
                gameState[tag]= yellow_code ;

                active_player= Red_code ;
            }

        im.animate().translationY(0f).setDuration(600);
    }
        // no winer : -1
    // red : Red_code
    //yellow : yellow_code
//     public int cheakWiner(){
//        for (int[] position :wining_positoin){
//            if (!(gameState[position[0]] = gameState[position[1]] &&
//                    gameState[position[1]] == gameState[position[2]])
//            ) {
//                continue;
//            }
//            return gameState[position[0]];
//        }
//
//
//    }
}
