package com.example.capstoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText user_id, user_pw;
    Button btn_login, user_join, find_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_id = (EditText) findViewById(R.id.user_id);
        user_pw = (EditText) findViewById(R.id.user_pw);
        btn_login = (Button) findViewById(R.id.btn_login);
        user_join = (Button) findViewById(R.id.user_join);
        find_user = (Button) findViewById(R.id.find_user);
// 로그인 버튼 클릭
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user_pw.getText().toString().equals("1234")) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "본인 확인 해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
// 회원가입 버튼 클릭시
        user_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LoginformActivity.class);
                startActivity(intent);
            }
        });
// 아이디/ 비번 찾기 클릭시
        find_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),FindAccount.class);
                startActivity(intent);

            }
        });

    }
}