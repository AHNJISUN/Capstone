package com.example.capstoneapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FindAccount extends AppCompatActivity {

    Button findIdBtn, findPwdBtn, AuthenCodeBtn, submitBtn, IDBtn;
    EditText inputEmail, inputAuthen;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_account);

        findIdBtn = (Button) findViewById(R.id.findIdBtn);
        findPwdBtn = (Button) findViewById(R.id.findPwdBtn);
       /* AuthenCodeBtn = (Button) findViewById(R.id.AuthenCodeBtn);
        submitBtn = (Button) findViewById(R.id.submitBtn);
        IDBtn = (Button) findViewById(R.id.IDBtn);
        inputEmail = (EditText) findViewById(R.id.InputEmail);
        inputAuthen = (EditText) findViewById(R.id.InputAuthen);*/

        findIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(FindAccount.this, R.layout.dialog_id_find, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(FindAccount.this);
                dlg.setTitle("아이디 찾기");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), FindAccount.class);
                        startActivity(intent);
                    }

                });
                dlg.show();

            }
        });

        findPwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(FindAccount.this, R.layout.dialog_pwd_find, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(FindAccount.this);
                dlg.setTitle("비밀번호 찾기");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), FindAccount.class);
                        startActivity(intent);
                    }

                });
                dlg.show();

            }
        });
    }
}