package com.example.siakunin.retrofitobservable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;
import java.util.List;

public class AnekdotActivity extends MvpAppCompatActivity implements AnekdotView {
        ProgressWheel progressWheel;
        RecyclerView recyclerView;
        LinearLayoutManager layoutManager;
        List<String> anekdots;
        AnekdotAdapter adapter;
        @InjectPresenter
        AnekdotPresenter presenter;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_anekdot);
                anekdots = new ArrayList<>();
                adapter = new AnekdotAdapter(anekdots);

                progressWheel = findViewById(R.id.progressBar);
                recyclerView = findViewById(R.id.recyclerView);

                layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

                recyclerView.setAdapter(adapter);
                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                                super.onScrollStateChanged(recyclerView, newState);
                        }

                        @Override
                        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                                super.onScrolled(recyclerView, dx, dy);
                                int visibleItemCount = layoutManager.getChildCount();//смотрим сколько элементов на экране
                                int totalItemCount = layoutManager.getItemCount();//сколько всего элементов
                                int firstVisibleItems = layoutManager.findFirstVisibleItemPosition();//какая позиция первого элемента

                                if (!presenter.isLoading &&
                                        (visibleItemCount + firstVisibleItems) >= totalItemCount) {
                                        presenter.loadAnekdots();
                                }
                        }
                });






        }

        @Override
        public void setProgressBarVisible(boolean visible) {
                if(visible)progressWheel.setVisibility(ProgressWheel.VISIBLE);
                else progressWheel.setVisibility(ProgressWheel.INVISIBLE);
        }

        @Override
        public void addNewAnekdot(String text) {
                anekdots.add(text);
                adapter.notifyItemInserted(anekdots.size()-1);
        }
        @Override
        public void setTypeInPresenter(){
                presenter.setType(getIntent().getIntExtra(MainActivity.TYPE,0));
        }

        @Override
        public void showMessage(String message) {
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }


}
