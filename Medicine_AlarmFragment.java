package com.example.capstoneapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Medicine_AlarmFragment extends BaseFragment implements AlarmAdapter.OnItemListener {

    private final AlarmData.Type alarmType = AlarmData.Type.MEDICINE;
    private final ArrayList<AlarmData> alarms = new ArrayList<>();

    private RecyclerView recyclerView;
    private AlarmAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medicine__alarm, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);
        recyclerView = view.findViewById(R.id.recycler_view);
        View emptyView = view.findViewById(R.id.empty_view);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_add) {
                showAlarmDialog(null);
            }

            return true;
        });

        adapter = new AlarmAdapter();
        adapter.setItemListener(this);
        recyclerView.setAdapter(adapter);

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            private void setEmptyViewVisibility() {
                emptyView.setVisibility(adapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                setEmptyViewVisibility();
            }

            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                setEmptyViewVisibility();
            }

            @Override
            public void onChanged() {
                setEmptyViewVisibility();
            }
        });

        // TODO: ????????? DB ?????? ????????? ???????????? ????????? ????????? ???
    }

    /*
     ?????? ?????? / ????????? ?????? Dialog ??? ???????????? ??????
     alarm ?????? ????????? ?????? ????????????, ????????? null
     */
    private void showAlarmDialog(@Nullable AlarmData alarm) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_working, null);

        TimePicker timePicker = view.findViewById(R.id.workingTimePicker);
        ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(view.findViewById(R.id.checkBoxNo));
        checkBoxes.add(view.findViewById(R.id.checkBoxSun));
        checkBoxes.add(view.findViewById(R.id.checkBoxMon));
        checkBoxes.add(view.findViewById(R.id.checkBoxTue));
        checkBoxes.add(view.findViewById(R.id.checkBoxWen));
        checkBoxes.add(view.findViewById(R.id.checkBoxThu));
        checkBoxes.add(view.findViewById(R.id.checkBoxFri));
        checkBoxes.add(view.findViewById(R.id.checkBoxSat));

        if (alarm != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(alarm.getTime());

            timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
            timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));

            if (alarm.getWeekday().isEmpty()) {
                checkBoxes.get(0).setChecked(true);

            } else {
                for (Integer week : alarm.getWeekday()) {
                    checkBoxes.get(week).setChecked(true);
                }
            }
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(requireContext());
        dialog.setView(view);
        dialog.setTitle("????????? ??????????????????");
        dialog.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                if (calendar.before(Calendar.getInstance())) {
                    calendar.add(Calendar.DATE, 1);
                }

                ArrayList<Integer> weekday = new ArrayList<>();
                if (!checkBoxes.get(0).isChecked()) {
                    for (int week = 1; week < checkBoxes.size(); week++) {
                        if (checkBoxes.get(week).isChecked()) {
                            weekday.add(week);
                        }
                    }
                }

                if (alarm == null) {
                    addAlarm(calendar.getTimeInMillis(), weekday);

                } else {
                    modifyAlarm(alarm.getId(), calendar.getTimeInMillis(), weekday, alarm.isActivation());
                }
            }
        });
        dialog.show();
    }

    /*
     ????????? ???????????? ??????
     time    ?????? ??????
     weekday ?????? ??????
     */
    private void addAlarm(long time, List<Integer> weekday) {
        AlarmData alarm = new AlarmData(alarmType, time, weekday, true);

        alarms.add(alarm);
        // TODO: ????????? DB ??? ???????????? ????????? ????????? ???
        registerAlarm(alarm);

        adapter.submitList(alarms);
    }

    /**
     * ?????? ??????, ??????, ???????????? ???????????? ??????
     id         ?????? ID
     time       ?????? ??????
     weekday    ?????? ??????
     activation ?????????
     */
    private void modifyAlarm(int id, long time, List<Integer> weekday, boolean activation) {
        for (int i = 0; i < alarms.size(); i++) {
            AlarmData alarm = alarms.get(i);

            if (alarm.getId() == id) {
                alarm.setTime(time);
                alarm.setWeekday(weekday);
                alarm.setActivation(activation);
                // TODO: ????????? DB ??? ???????????? ????????? ????????? ???
                registerAlarm(alarm);

                int finalI = i;
                recyclerView.post(() -> adapter.notifyItemChanged(finalI));

                return;
            }
        }
    }

    /*
     * ?????? ???????????? ???????????? ??????
     id         ?????? ID
     activation ?????????
     */
    private void modifyAlarm(int id, boolean activation) {
        for (int i = 0; i < alarms.size(); i++) {
            AlarmData alarm = alarms.get(i);

            if (alarm.getId() == id) {
                alarm.setActivation(activation);
                // TODO: ????????? DB ??? ???????????? ????????? ????????? ???
                registerAlarm(alarm);

                return;
            }
        }
    }

    @Override
    public void onItemClicked(AlarmData alarm) {
        showAlarmDialog(alarm);
    }

    @Override
    public void onSwitchChanged(AlarmData alarm, boolean checked) {
        modifyAlarm(alarm.getId(), checked);
    }
}
