package com.example.capstoneapp;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected void registerAlarm(AlarmData alarm) {
        AlarmReceiver.registerAlarm(requireContext(), alarm);
    }
}
