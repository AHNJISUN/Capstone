package com.example.capstoneapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AlarmAdapter extends ListAdapter<AlarmData, AlarmAdapter.ViewHolder> {

    public interface OnItemListener {
        void onItemClicked(AlarmData alarm);

        void onSwitchChanged(AlarmData alarm, boolean checked);
    }


    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private final SimpleDateFormat shortWeekdayFormat = new SimpleDateFormat("EEE", Locale.getDefault());
    private final SimpleDateFormat fullWeekdayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    private OnItemListener itemListener;


    public AlarmAdapter() {
        super(new DiffUtil.ItemCallback<AlarmData>() {
            @Override
            public boolean areItemsTheSame(@NonNull AlarmData oldItem, @NonNull AlarmData newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull AlarmData oldItem, @NonNull AlarmData newItem) {
                if (oldItem.getWeekday().size() != newItem.getWeekday().size()) return false;
                for (Integer week : oldItem.getWeekday()) {
                    if (!newItem.getWeekday().contains(week)) {
                        return false;
                    }
                }

                return oldItem.getTime() == newItem.getTime() &&
                        oldItem.isActivation() == newItem.isActivation();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlarmData alarm = getItem(position);

        holder.timeTextView.setText(timeFormat.format(new Date(alarm.getTime())));

        if (alarm.getWeekday().isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(alarm.getTime());

            holder.weekdayTextView.setText("알람, " + dateFormat.format(calendar.getTime()));

        } else if (alarm.getWeekday().size() == 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_WEEK, alarm.getWeekday().get(0));

            holder.weekdayTextView.setText("알람, " + fullWeekdayFormat.format(calendar.getTime()) + "마다");

        } else {
            holder.weekdayTextView.setText("알람, ");

            Calendar calendar = Calendar.getInstance();

            for (Integer week : alarm.getWeekday()) {
                calendar.set(Calendar.DAY_OF_WEEK, week);
                holder.weekdayTextView.append(shortWeekdayFormat.format(calendar.getTime()) + " ");
            }
        }

        holder.activationSwitch.setChecked(alarm.isActivation());
        holder.timeTextView.setEnabled(alarm.isActivation());

        holder.itemView.setOnClickListener(v -> {
            if (itemListener != null) {
                itemListener.onItemClicked(getItem(holder.getAdapterPosition()));
            }
        });

        holder.activationSwitch.setOnCheckedChangeListener((compoundButton, b) -> {
            holder.timeTextView.setEnabled(b);

            if (itemListener != null) {
                itemListener.onSwitchChanged(getItem(holder.getAdapterPosition()), b);
            }
        });
    }

    @Override
    public void submitList(@Nullable List<AlarmData> list) {
        submitList(list, null);
    }

    @Override
    public void submitList(@Nullable List<AlarmData> list, @Nullable Runnable commitCallback) {
        if (list != null) {
            super.submitList(new ArrayList<>(list), commitCallback);

        } else {
            super.submitList(null, commitCallback);
        }
    }

    public void setItemListener(OnItemListener listener) {
        this.itemListener = listener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView timeTextView;
        TextView weekdayTextView;
        SwitchMaterial activationSwitch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            timeTextView = itemView.findViewById(R.id.time_text_view);
            weekdayTextView = itemView.findViewById(R.id.weekday_text_view);
            activationSwitch = itemView.findViewById(R.id.activation_switch);
        }
    }
}
