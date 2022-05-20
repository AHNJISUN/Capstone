package com.example.capstoneapp;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AlarmData implements Parcelable {

    private static int ID = 0;
    enum Type {
        HOSPITAL, WORKING, MEDICINE
    }

    private final int id;
    private final int type;
    private long time;
    private List<Integer> weekday = new ArrayList<>();
    private boolean activation = true;


    public AlarmData(Type type, long time, List<Integer> weekday, boolean activation) {
        this.id = ID++;
        this.type = type.ordinal();
        this.time = time;
        this.weekday = weekday;
        this.activation = activation;
    }

    public AlarmData(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getInt("id");
        this.type = jsonObject.getInt("type");
        this.time = jsonObject.getLong("time");

        JSONArray jsonArray = jsonObject.getJSONArray("weekday");
        for (int i = 0; i < jsonArray.length(); i++) {
            this.weekday.add(jsonArray.getInt(i));
        }

        this.activation = jsonObject.getBoolean("activation");
    }

    protected AlarmData(Parcel in) {
        id = in.readInt();
        type = in.readInt();
        time = in.readLong();
        in.readList(weekday, Integer.class.getClassLoader());
        activation = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(type);
        dest.writeLong(time);
        dest.writeList(weekday);
        dest.writeByte((byte) (activation ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AlarmData> CREATOR = new Creator<AlarmData>() {
        @Override
        public AlarmData createFromParcel(Parcel in) {
            return new AlarmData(in);
        }

        @Override
        public AlarmData[] newArray(int size) {
            return new AlarmData[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Integer> getWeekday() {
        return weekday;
    }

    public void setWeekday(List<Integer> weekday) {
        this.weekday = weekday;
    }

    public boolean isActivation() {
        return activation;
    }

    public void setActivation(boolean activation) {
        this.activation = activation;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("type", type);
        jsonObject.put("time", time);

        JSONArray jsonArray = new JSONArray();
        for (int week : weekday) {
            jsonArray.put(week);
        }

        jsonObject.put("weekday", jsonArray);
        jsonObject.put("activation", activation);

        return jsonObject;
    }
}
