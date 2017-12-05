package com.example.siakunin.retrofitobservable;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * Created by siakunin on 04.12.2017.
 */
@InjectViewState
public class AnekdotPresenter extends MvpPresenter<AnekdotView> {
    private int type = 0;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    private ApiAnekdot apiAnekdot = Model.getApi();

    public void loadAnekdots(){
        apiAnekdot.getContent(type)
                .retry(5L)
                .repeat(10)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Anekdot>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Anekdot s) {
                        Log.d("Anekdot",s.getContent());
                        getViewState().addNewAnekdot(s.getContent());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //getViewState().showMessage("Не удалось загрузить данные");
                        Log.e("Anekdot",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().setTypeInPresenter();

        switch (type){
            case Anekdot.JOKE: getViewState().setTitle(R.string.joke);break;
            case Anekdot.STORY: getViewState().setTitle(R.string.story);break;
            case Anekdot.VERSE: getViewState().setTitle(R.string.verse);break;
            case Anekdot.APHORISM: getViewState().setTitle(R.string.aphorism);break;
            case Anekdot.CITATION: getViewState().setTitle(R.string.citation);break;
            case Anekdot.TOAST: getViewState().setTitle(R.string.toast);break;
            case Anekdot.STATUS: getViewState().setTitle(R.string.status);break;
            case Anekdot.JOKE18: getViewState().setTitle(R.string.joke18);break;
            case Anekdot.STORY18: getViewState().setTitle(R.string.story18);break;
            case Anekdot.VERSE18: getViewState().setTitle(R.string.verse18);break;
            case Anekdot.APHORISM18: getViewState().setTitle(R.string.aphorism18);break;
            case Anekdot.CITATION18: getViewState().setTitle(R.string.citation18);break;
            case Anekdot.TOAST18: getViewState().setTitle(R.string.toast18);break;
            case Anekdot.STATUS18: getViewState().setTitle(R.string.status18);break;

            default: getViewState().setTitle(R.string.joke);

        }

        loadAnekdots();


    }
}
