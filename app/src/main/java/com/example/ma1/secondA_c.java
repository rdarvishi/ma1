package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class secondA_c extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_a_c);

        TextView etra_TV = findViewById(R.id.textView_extra);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = "";
            String mail = "";
            String phone = "";

            if (extras.containsKey("name")) {
                name = extras.getString("name");
            }
            if (extras.containsKey("mail")) {
                mail = extras.getString("mail");
            }
            if (extras.containsKey("phone")) {
                phone = extras.getString("phone");
            }

            etra_TV.setText("name : " + name + "\n");
            if (extras.containsKey("phone")) {
                etra_TV.append("phone : " + phone + "\n");
            }

            etra_TV.append("Email  : " + mail + "\n");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem item = menu.add("CONFIRM");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                intent.putExtra("ok", "all data confirmed");
                finish();
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
