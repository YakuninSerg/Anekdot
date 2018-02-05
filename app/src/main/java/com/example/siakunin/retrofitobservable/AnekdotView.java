package com.example.siakunin.retrofitobservable;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

/**
 * Created by siakunin on 04.12.2017.
 */

public interface AnekdotView extends MvpView {
    void setProgressBarVisible(boolean visible);
    void addNewAnekdot(String text);
    void setTitle(@StringRes int title);
    void setTypeInPresenter();
    @StateStrategyType(SkipStrategy.class)
    void showMessage(String message);
    void setAnekdots();


}
