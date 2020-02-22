package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup ;
    RadioButton RB1 ,RB2,RB3,RB4 ;
    Button btn_display ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        radioGroup = findViewById(R.id.RadioGroup_id);
        rbclick();

        btn_display = findViewById(R.id.button_display_id);

        btn_display.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        if (v.getId()== btn_display.getId()){
       int rb_id = radioGroup.getCheckedRadioButtonId();
       RadioButton rb = findViewById(rb_id);

            if (rb != null){
                String text = rb.getText().toString();
                String tag = rb.getTag().toString();


                //Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, tag, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "please select your town ", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private void rbclick() {
//        //        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
////            @Override
////            public void onCheckedChanged(RadioGroup group, int checkedId) {
////
////               RadioButton rb = findViewById(radioGroup.getCheckedRadioButtonId());
////
////               rb.setBackgroundResource(R.drawable.radio_button_a);
////            }
////        });
    }


}
