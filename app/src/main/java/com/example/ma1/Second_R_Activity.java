package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Second_R_Activity extends AppCompatActivity {
    ImageView imageView ;
    TextView TV_title , TV_discraption ;

    String data1, data2 ;
    int myimage ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__r_);

        imageView = findViewById(R.id.iv_re_id);
        TV_title = findViewById(R.id.textView_title);
        TV_discraption = findViewById(R.id.textView_disc_id);

        getData();
        setData();
    }
    private void getData(){
        if (getIntent().hasExtra("data1")&& getIntent().hasExtra("data2")&&getIntent().hasExtra("myimage")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myimage = getIntent().getIntExtra("myimage",1);
        }else{
            Toast.makeText(this, "NO DATA . . . ", Toast.LENGTH_SHORT).show();
        }
    }

    private void  setData(){
        TV_title.setText(data1);
        TV_discraption.setText(data2);
        imageView.setImageResource(myimage);
    }
}
