package com.czt.saisam.unittest;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weichyang on 2016/12/28.
 * esspross 常用单元测试
 */

public class LogHistory implements Parcelable {

    public String testString;
    public long testLong;
    private List<Pair<String, Long>> data = new ArrayList<>();

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public LogHistory() {
    }

    protected LogHistory(Parcel in) {

    }

    public static final Parcelable.Creator<LogHistory> CREATOR = new Parcelable.Creator<LogHistory>() {
        public LogHistory createFromParcel(Parcel source) {
            return new LogHistory(source);
        }

        public LogHistory[] newArray(int size) {
            return new LogHistory[size];
        }
    };

    public void addEntry(String testString, long testLong) {
        this.testString = testString;
        this.testLong = testLong;
        Pair<String, Long> pair = new Pair<>(testString, testLong);
        if (data != null)
            data.add(pair);
    }

    public List<Pair<String, Long>> getData() {
        return data;
    }
}
