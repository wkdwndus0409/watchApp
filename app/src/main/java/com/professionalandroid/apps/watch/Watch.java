package com.professionalandroid.apps.watch;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Watch {
    private String mId;
    private Date mDate;
    private String mCountry;
    private String mDetails;
    private String mLink;

    public String getId() {return mId;}
    public Date getDate() {return mDate;}
    public String getCountry() {return mCountry;}
    public String getDetails() {return mDetails;}
    public String mLink() {return mLink;}

    public Watch(String id, Date date, String country, String details, String link) {
        mId = id;
        mDate = date;
        mCountry = country;
        mDetails = details;
        mLink = link;
    }

    @NonNull
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd.HH:mm", Locale.KOREA);
        String dateString = sdf.format(mDate);
        return mCountry + ": " + dateString;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Watch)
            return (((Watch)obj).getId().contentEquals(mId));
        else
            return false;
    }
}
