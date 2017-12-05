package com.example.siakunin.retrofitobservable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends AppCompatActivity implements MainView{
public static final String TYPE = "type";
@InjectPresenter
MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view) {
        int type = 0;
        switch (view.getId()){
            case R.id.joke_button: type = Anekdot.JOKE; break;
            case R.id.story_button: type = Anekdot.STORY; break;
            case R.id.verse_button: type = Anekdot.VERSE; break;
            case R.id.aphorism_button:  type = Anekdot.APHORISM; break;
            case R.id.citation_button:  type = Anekdot.CITATION; break;
            case R.id.toast_button:  type = Anekdot.TOAST; break;
            case R.id.status_button:  type = Anekdot.STATUS; break;
            case R.id.joke18_button:  type = Anekdot.JOKE18; break;
            case R.id.story18_button:  type = Anekdot.STORY18; break;
            case R.id.verse18_button:  type = Anekdot.VERSE18; break;
            case R.id.aphorism18_button:  type = Anekdot.APHORISM18; break;
            case R.id.citation18_button:  type = Anekdot.CITATION18; break;
            case R.id.toast18_button:  type = Anekdot.TOAST18; break;
            case R.id.status18_button:  type = Anekdot.STATUS18; break;

            default: type = Anekdot.JOKE;

        }

           startAnekdotActivity(type);
    }

    @Override
    public void startAnekdotActivity(int type) {
        Intent intent = new Intent(MainActivity.this,AnekdotActivity.class);
        intent.putExtra(TYPE,type);
        startActivity(intent);
    }
}
