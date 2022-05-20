package com.example.capstoneapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;

public class SimpleLoginActivity extends AppCompatActivity {
    Button simplePwdBtn,patternBtn,fingerprintBtn,submitOKBtn;
    View simplepewdDlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_login);
        simplePwdBtn = (Button) findViewById(R.id.simplePwdBtn);
        patternBtn = (Button) findViewById(R.id.patternBtn);
        fingerprintBtn = (Button) findViewById(R.id.fingerprintBtn);
        submitOKBtn = (Button)findViewById(R.id.submitOKBtn);

        simplePwdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simplepewdDlg = (View) View.inflate(SimpleLoginActivity.this, R.layout.dialog_simple_pwd, null);
                AlertDialog.Builder dlg_pwd = new AlertDialog.Builder(SimpleLoginActivity.this);
                dlg_pwd.setView(simplepewdDlg);
                dlg_pwd.show();

            }
        });
        patternBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        fingerprintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        submitOKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PetInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}