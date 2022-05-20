package com.example.capstoneapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Toast;

public class AlarmActivity extends AppCompatActivity {
    private static final int NUM_PAGES=3;
    ViewPager2 viewPager2;
    FragmentStateAdapter fragmentStateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        viewPager2 = findViewById(R.id.alarmViewpager);
        fragmentStateAdapter = new ScreeSlidePagerAdapter(this);
        viewPager2.setAdapter(fragmentStateAdapter);

    }
    @Override public void onBackPressed() {
        if(viewPager2.getCurrentItem()==0)
        { Toast.makeText(this, "뒤로가기가 눌렸습니다.", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }else{
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()-1); } }


    private class ScreeSlidePagerAdapter extends FragmentStateAdapter{
        public ScreeSlidePagerAdapter(FragmentActivity fa) {
            super (fa);
        }
        @NonNull
        @Override
        public Fragment createFragment(int position)
        {
            if(position==0) return new Working_AlarmFragment();
            else if (position==1)return new Hospital_AlarmFragment();
            else return new Medicine_AlarmFragment();

        }
        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

}

