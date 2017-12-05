package com.example.siakunin.retrofitobservable;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

/**
 * Created by siakunin on 04.12.2017.
 */

public interface AnekdotView extends MvpView {
    void setProgressBarVisible(boolean visible);
    void addNewAnekdot(String text);
    void setTitle(@StringRes int title);
    void setTypeInPresenter();
    void showMessage(String message);


}
