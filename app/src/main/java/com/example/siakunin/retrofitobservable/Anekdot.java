package com.example.siakunin.retrofitobservable;

/**
 * Created by siakunin on 04.12.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Anekdot {

    public static final int JOKE =   1;
    public static final int STORY =  2;
    public static final int VERSE = 3;
    public static final int APHORISM = 4;
    public static final int CITATION = 5;
    public static final int TOAST = 6;
    public static final int STATUS = 8;
    public static final int JOKE18 = 11;
    public static final int STORY18 = 12;
    public static final int VERSE18 = 13;
    public static final int APHORISM18 = 14;
    public static final int CITATION18 = 15;
    public static final int TOAST18 = 16;
    public static final int STATUS18 = 18;


    @SerializedName("content")
    @Expose
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
