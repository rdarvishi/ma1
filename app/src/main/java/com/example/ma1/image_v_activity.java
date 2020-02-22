package com.example.ma1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class image_v_activity extends AppCompatActivity implements View.OnClickListener {
    ImageView iv_football, iv_basketball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_v_activity);
        iv_football = findViewById(R.id.iv_football);
        iv_basketball = findViewById(R.id.iv_basketball);

        fade();

        iv_football.setOnClickListener(this);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == iv_football.getId()) {
            fade();
        } else if (v.getId() == iv_basketball.getId()) {
            //fade();
        }
    }

    private void fade() {

        iv_football.animate().alpha(1f-iv_football.getAlpha()).setDuration(2000);
        iv_basketball.animate().alpha(1f-iv_basketball.getAlpha()).setDuration(2000);
    }
}
