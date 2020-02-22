package com.example.ma1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class secondA extends AppCompatActivity {

    public static final int REQ_CODE=12 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Forminfo form = new Forminfo(this, R.id.layout_form_info);

//        EditText name =  (EditText) findViewById(R.id.input_name);
//        EditText phone =  (EditText) findViewById(R.id);
//        EditText name =  (EditText) findViewById(R.id.input_name);
//
        form.getInputname().setTextColor(Color.rgb(200, 100, 50));

        form.getBtnsubmit().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= form.getInputname().getText().toString().trim();
                String phone= form.getInputphone().getText().toString().trim();
                String mail= form.getInputmail().getText().toString().trim();

                if (form.IsValidInput(name, phone, mail)) {
                    Intent intent = new Intent(secondA.this,secondA_c.class);

                    intent.putExtra("name",name);

                    intent.putExtra("mail",mail);
                    if (form.getCbsharephone().isChecked()){
                        intent.putExtra("phone",phone);
                    }



                    startActivityForResult(intent,REQ_CODE);

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQ_CODE && resultCode==RESULT_OK){

                Toast.makeText(this, data.getStringExtra("ok"), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("myItrem1");
        menu.add("myItrem2");
        menu.add("myItrem3");
        SubMenu subMenu = menu.addSubMenu("sum 1 ");
        subMenu.add("sub 1");
        subMenu.add("sub 2");
        subMenu.add("sub 3");


        return super.onCreateOptionsMenu(menu);
    }
}