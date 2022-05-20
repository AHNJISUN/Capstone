package com.example.capstoneapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class MainFragment extends Fragment {
    ImageView feed,health,camera,alarm,pet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        feed = (ImageView) view.findViewById(R.id.feed);
        health = (ImageView) view.findViewById(R.id.health);
        camera = (ImageView) view.findViewById(R.id.camera);
        alarm = (ImageView) view.findViewById(R.id.alarm);
        pet = (ImageView) view.findViewById(R.id.pet);

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"사료",Toast.LENGTH_LONG).show();
            }
        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), BoardActivity.class);
                startActivity(intent);

            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AlarmActivity.class);
                startActivity(intent);

            }
        });
        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PetLifecycle_Activity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
