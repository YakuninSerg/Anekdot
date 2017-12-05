package com.example.siakunin.retrofitobservable;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

/**
 * Created by siakunin on 05.12.2017.
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView>{

    public void startAnekdotActivity(int type){
        getViewState().startAnekdotActivity(type);
    }

}
