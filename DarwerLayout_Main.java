package com.example.capstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MainFragment mainFragment;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBar();
    }
    private void createBar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        mainFragment = new MainFragment();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.constraintLayout, mainFragment, null);
        fragmentTransaction.commit();
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> drawerLayout.open());
        toolbar.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.alarm) {
                Toast.makeText(getApplicationContext(), "한줄알림", Toast.LENGTH_SHORT).show();

            }
            return true;
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.menu_map) {
                Intent intent = new Intent(getApplicationContext(), WalkingViewActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "산책하기", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.menu_page) {
                Intent intent = new Intent(getApplicationContext(), MyPageActivity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "마이페이지", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.menu_feed) {
                Toast.makeText(getApplicationContext(), "사료", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.menu_alarm) {
                Intent intent = new Intent(getApplicationContext(), AlarmActivity.class);
                startActivity(intent);
            } else if (itemId == R.id.menu_health) {
                Toast.makeText(getApplicationContext(), "건강", Toast.LENGTH_SHORT).show();
            }

            drawerLayout.close();

            return true;
        });
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isOpen()) {
            drawerLayout.close();
            return;
        }
        super.onBackPressed();
    }

}
