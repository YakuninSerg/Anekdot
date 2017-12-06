package com.example.siakunin.retrofitobservable;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

 class Anekdot {

    static final int JOKE =   1;
    static final int STORY =  2;
    static final int VERSE = 3;
    static final int APHORISM = 4;
    static final int CITATION = 5;
    static final int TOAST = 6;
    static final int STATUS = 8;
    static final int JOKE18 = 11;
    static final int STORY18 = 12;
    static final int VERSE18 = 13;
    static final int APHORISM18 = 14;
    static final int CITATION18 = 15;
    static final int TOAST18 = 16;
    static final int STATUS18 = 18;


    @SerializedName("content")
    @Expose
    private String content;

    String getContent() {
        return content;
    }

     void setContent(String content){
        this.content = content;
     }

 }
