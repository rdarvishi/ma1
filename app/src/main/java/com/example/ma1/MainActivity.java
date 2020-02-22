package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView dataT, tv;
    private Button btn;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        final TextView dataT = findViewById(R.id.textDate);
        final EditText editText = findViewById(R.id.editText);
        final TextView tv = findViewById(R.id.tV);
        dataT.setText("man az in ayande . . . \n" + new Date().toString());


        btn.setOnClickListener(v -> {

            Random ranC = new Random();
            int coler = Color.argb(255, ranC.nextInt(256), ranC.nextInt(256), ranC.nextInt(256));
            btn.setBackgroundColor(coler);

            int TwC = Color.argb(ranC.nextInt() + 100, ranC.nextInt(256) + 150, ranC.nextInt(100), ranC.nextInt(256 - 156) + 100);

            dataT.setTextColor(TwC);
//                String s = editText.getText().toString().trim()

            dataT.setText(editText.getText().toString().trim());
        });
        editText.setOnFocusChangeListener((v, hasFocus) -> Toast.makeText(MainActivity.this, "focus change", Toast.LENGTH_SHORT).show());

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    // public void Toast_btn(View view) {
    //  Toast.makeText(MainActivity.this,"text hear (0_0)",Toast.LENGTH_SHORT).show();

//        Intent i = new Intent(MainActivity.this,secondA.class);
//        startActivity(i);
//        dataT.setTextColor(Color.rgb(23,43,122));

//dataT.setText((CharSequence) new Date(TimeZone.getTimeZone("tehran").toString()));
//


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem form = menu.add("form info");
        form.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        form.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(MainActivity.this, secondA.class);
                startActivity(i);
                return false;
            }
        });

        SubMenu intent_options = menu.addSubMenu("intent options");
        intent_options.add("open browser").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
                return false;
            }
        });
        intent_options.add("open sms").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:1000"));
                intent.putExtra("sms_body", "this is a test sms");
                startActivity(intent);

                return false;
            }
        });
        intent_options.add("open dialer").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:1000"));
                startActivity(intent);
                return false;
            }
        });

        SubMenu media = menu.addSubMenu("Media");
        media.add("image view").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, image_v_activity.class);
                startActivity(intent);
                return false;
            }
        });
media.add("video view").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem item) {

        Intent i= new Intent(MainActivity.this,video_View_activity.class);
        startActivity(i);
        return false;
    }
});

media.add("media player").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Intent i= new Intent(MainActivity.this,Audio_Activity.class);
        startActivity(i);
        return false;
    }
});
        menu.add("connect_three three").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, Tic_Tac_Toe.class);
                startActivity(intent);

                return false;
            }
        });

        menu.add("Dialog").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                return false;
            }
        });
        SubMenu list = menu.addSubMenu("list");

        list.add("simple list").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent i = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(i);
                return false;
            }
        });

        menu.add("Radio button").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                startActivity(new Intent(MainActivity.this,RadioButtonActivity.class));
                return false;
            }
        });
        menu.add("Rating bar").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(MainActivity.this,RatingBarActivity.class));

                return false;
            }
        });

menu.add("Spinner").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        startActivity(new Intent(MainActivity.this,SpinnerActivity.class));

        return false;
    }
});
        return super.onCreateOptionsMenu(menu);
    }

//    public boolean itemclick(MenuItem item) {
//        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
//
//        return true;
//    }


    //   @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.app_bar_search) {
//            Toast.makeText(this, item.getTitle() + "الان روی ایتم سرچ که ایدیش رو داده بودیم کلیک شد ", Toast.LENGTH_SHORT).show();
//
//
//        }
//        if (item.getItemId()==R.id.form_info_id){
//
//            Intent i = new Intent(this, secondA.class);
//            startActivity(i);
//        }
////        else if (item.getItemId() == R.id.secondPage) {
////            Intent i = new Intent(this, secondA.class);
////            startActivity(i);
////        } else
//
//
//            Toast.makeText(this, item.getTitle() + " آیتم هایی که ایدی ندادیم بهشون", Toast.LENGTH_SHORT).show();
//
//        return super.onOptionsItemSelected(item);
//    }
}

