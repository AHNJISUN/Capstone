package com.example.capstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginformActivity extends AppCompatActivity {
    EditText user_id,user_pwd,user_pwd_confirm,user_name,userEmail_code,user_brith;
    Button submit_btn,id_Overlab_btn,email_code_btn;
    RadioGroup radioGroupGender,radioGroupTerms;
    RadioButton women_rbtn,men_rbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginform);
        //EditText
        user_id = (EditText) findViewById(R.id.userIdView);
        user_pwd = (EditText) findViewById(R.id.userPwdView);
        user_pwd_confirm = (EditText) findViewById(R.id.userPwdTwoView);
        user_name = (EditText) findViewById(R.id.userNameView);
        userEmail_code = (EditText) findViewById(R.id.userEmailView);
        user_brith = (EditText) findViewById(R.id.userBirthView);
        //Button
        submit_btn = (Button) findViewById(R.id.submitBtn);
        id_Overlab_btn = (Button)findViewById(R.id.id_Overlab_btn);
        email_code_btn = (Button) findViewById(R.id.email_code_btn);
        //RadioGroup, RadioButton
        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioGroupTerms = (RadioGroup)findViewById(R.id.termsRadioGroup);
        women_rbtn = (RadioButton)findViewById(R.id.radioWomenBtn);
        men_rbtn = (RadioButton)findViewById(R.id.radioMenBtn);

        //성별 check
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioWomenBtn){
                    Toast.makeText(getApplicationContext(),"여성",Toast.LENGTH_LONG).show();
                }else if(i == R.id.radioMenBtn){
                    Toast.makeText(getApplicationContext(),"남성",Toast.LENGTH_LONG).show();
                }
            }
        });
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SimpleLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}