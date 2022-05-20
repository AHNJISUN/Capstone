package com.example.capstoneapp;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {

    public static String ARG_ALARM = "ARG_ALARM";
    private final String CHANNEL_ID = "Alarm";


    public static void registerAlarm(Context context, AlarmData alarm) {
        unregisterAlarm(context, alarm);

        if (!alarm.isActivation()) return;

        Calendar now = Calendar.getInstance();

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(alarm.getTime());

        if (alarm.getWeekday().isEmpty()) {
            if (calendar.before(now)) {
                return;
            }
        } else {
            long nextTime = Long.MAX_VALUE;

            // 반복 요일 중, 현재 이후 가장 가까운 날 찾기
            for (int i = 0; i < 2; i++) {
                calendar = Calendar.getInstance();
                calendar.setTimeInMillis(alarm.getTime());
                calendar.add(Calendar.DATE, 7 * i);

                for (int week : alarm.getWeekday()) {
                    calendar.set(Calendar.DAY_OF_WEEK, week);

                    if (calendar.after(now)) {
                        nextTime = Math.min(nextTime, calendar.getTimeInMillis());
                    }
                }
            }

            calendar.setTimeInMillis(nextTime);
        }

        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(applicationContext,
                alarm.getId(),
                getIntent(context, alarm),
                PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    private static void unregisterAlarm(Context context, AlarmData alarm) {
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(applicationContext,
                alarm.getId(),
                getIntent(context, alarm),
                PendingIntent.FLAG_NO_CREATE);

        if (pendingIntent != null && alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    private static Intent getIntent(Context context, AlarmData alarm) {
        Context applicationContext = context.getApplicationContext();

        Intent intent = new Intent(applicationContext, AlarmReceiver.class);
        Bundle bundle = new Bundle();
        try {
            bundle.putString(AlarmReceiver.ARG_ALARM, alarm.toJSONObject().toString());
            intent.putExtras(bundle);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return intent;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("AlarmReceiver", "onReceive");

        String jsonString = intent.getStringExtra(ARG_ALARM);
        if (jsonString == null) {
            Log.d("AlarmReceiver", "ARG_ALARM is null.");
            return;
        }

        AlarmData alarm;

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            alarm = new AlarmData(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        createNotificationChannel(context);

        String title = "";
        String content = "";

        if (alarm.getType() == AlarmData.Type.WORKING.ordinal()) {
            title = "산책 알람";
            content = "산책 갈 시간이예요.";

        } else if (alarm.getType() == AlarmData.Type.MEDICINE.ordinal()) {
            title = "약 알람";
            content = "약 먹을 시간이예요.";

        } else {
            title = "병원 알람";
            content = "병원 갈 시간이예요.";
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_stat_alarm)
                .setContentTitle(title)
                .setContentText(content)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat.from(context).notify(alarm.getId(), builder.build());

        // 반복이 있는 경우, 다음 알람을 등록
        if (!alarm.getWeekday().isEmpty()) {
            registerAlarm(context, alarm);
        }
    }

    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "알람";
            String description = "알람 시간에 알림 메세지를 표시합니다.";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}