package com.example.ma1;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.security.PrivateKey;

public class Forminfo {
    private Activity activity ;
    private LinearLayout layoutForminfo ;
    private EditText inputname ;
    private EditText inputphone ;
    private EditText inputmail ;
    private CheckBox cbsharephone ;
    private Button btnsubmit ;


    public Forminfo( Activity activity , int layoutId ){

        this.activity = activity ;
        layoutForminfo = activity.findViewById(layoutId);
        init();

    }
    private void init(){
        if (layoutForminfo==null){
            return;
        }
        inputname = layoutForminfo.findViewById(R.id.input_name);
        inputmail = layoutForminfo.findViewById(R.id.input_email);
        inputphone = layoutForminfo.findViewById(R.id.input_phone);
        cbsharephone = layoutForminfo.findViewById(R.id.cb_share_phone);
        btnsubmit = layoutForminfo.findViewById(R.id.submit_id);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputname.getText().toString().trim();
                String phone = inputphone.getText().toString().trim();
                String mail = inputmail.getText().toString().trim();

                if (IsValidInput(name , phone , mail)){
                    Toast.makeText(activity, "  OK (0_0) data is vlid ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity,secondA_c.class);
                    intent.putExtra("name",name);
                    if (cbsharephone.isChecked()){
                        intent.putExtra("phone",phone);
                    }

                    intent.putExtra("mail",mail);


                    activity.startActivity(intent);
                }


            }
        });

        cbsharephone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                inputphone.setEnabled(isChecked);
            }
        });

    }

    public EditText getInputname() {
        return inputname;
    }

    public EditText getInputphone() {
        return inputphone;
    }

    public EditText getInputmail() {
        return inputmail;
    }

    public CheckBox getCbsharephone() {
        return cbsharephone;
    }

    public Button getBtnsubmit() {
        return btnsubmit;
    }

    public boolean IsValidInput(String name , String phone , String mail){

        if (name == null)
            name=inputname.getText().toString().trim();
        if (phone == null)
            phone=inputphone.getText().toString().trim();
        if (mail == null)
            mail=inputmail.getText().toString().trim();

        if (name.length()<3){
            Toast.makeText(activity, "name error"+"اسم نباید کمتر از 3 حرف باشد ", Toast.LENGTH_SHORT).show();
          inputname.requestFocus();
            return false ;
        }
            if (!phone.isEmpty() && (phone.length()!=11 || !phone.startsWith("09"))){
                Toast.makeText(activity, "wrong phone number", Toast.LENGTH_SHORT).show();
                inputphone.requestFocus();
                return false ;
            }
            if ((mail.lastIndexOf('@')<= 0 ||
                    !mail.contains(".")||
                    mail.lastIndexOf('.') < mail.lastIndexOf('@')||
                    mail.split("@").length<2)) {
            Toast.makeText(activity, "wrong mail ", Toast.LENGTH_SHORT).show();
            inputmail.requestFocus();

                return false ;
        }


 return true ;
    }
}
