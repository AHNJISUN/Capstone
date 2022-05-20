package com.example.capstoneapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PetLifecycle_Activity extends AppCompatActivity {
    View dialogView;
    ImageView age_img, tran_img, teen_img, youth_img, social_img, adult_img, old_img;
    Button nur_btn, heal_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_lifecycle);
        age_img = (ImageView) findViewById(R.id.new_age);
        tran_img = (ImageView) findViewById(R.id.tran_age);
        teen_img = (ImageView) findViewById(R.id.teen_age);
        youth_img = (ImageView) findViewById(R.id.youth_age);
        social_img = (ImageView) findViewById(R.id.social_age);
        adult_img = (ImageView) findViewById(R.id.adult_age);
        old_img = (ImageView) findViewById(R.id.old_age);
        nur_btn = (Button) findViewById(R.id.Nur_Btn);
        heal_btn = (Button) findViewById(R.id.Heal_Btn);

        age_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.new_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        tran_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.tran_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        teen_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.teen_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        social_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.social_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        youth_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.youth_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        adult_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.adult_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        old_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.old_age_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        nur_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.nur_info_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
        heal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(PetLifecycle_Activity.this, R.layout.health_info_layout, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(PetLifecycle_Activity.this);
                dlg.setView(dialogView);
                dlg.show();
            }
        });
    }
}