package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {
    RatingBar ratingBar ;
    Button submit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar = findViewById(R.id.ratingBar_id);
        submit= findViewById(R.id.btn_rating);

        ratingBar.setMax(10);
//        ratingBar.setRating(7.5f);

        click();

        ratingClick();

    }

    private void ratingClick() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser){

                    Toast.makeText(RatingBarActivity.this, " rate : " +rating , Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void click() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(RatingBarActivity.this, " rate : " +ratingBar.getRating() , Toast.LENGTH_SHORT).show();
                ratingBar.setRating(3);
            }
        });
    }
}
