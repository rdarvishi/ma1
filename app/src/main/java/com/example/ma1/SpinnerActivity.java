package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    Spinner simple_spinner ;
    String[] simpleitem ;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        simple_spinner = findViewById(R.id.Simple_spinner_id);
        simpleitem = getResources().getStringArray(R.array.tour);

        simplespiner();




    }



    private void simplespiner() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout
        .simple_spinner_item,simpleitem);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        simple_spinner.setAdapter(arrayAdapter);
      simple_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(SpinnerActivity.this, " item : "+parent.getSelectedItem(), Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });
    }



}
