package com.desgin.srdz.desgindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CoordinatorActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener, View.OnClickListener {
    TextView tv;
    RecyclerView recycle;
    List<String> list;
    Toolbar toolbar;
    FloatingActionButton fob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recycle = (RecyclerView)findViewById(R.id.lay_recycle);
        list = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add(String.format(Locale.CHINA,i+"条数据",1));
        }
        recycle.setAdapter(new MyRecycleAdapter(this,list));
        tv = (TextView) findViewById(R.id.btn_coordinator);


        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)tv.getLayoutParams();
       //左滑消失
//        SwipeDismissBehavior<TextView> behavior= new SwipeDismissBehavior<>();
//        behavior.setListener(this);
//        params.setBehavior(behavior);


      //下滑消失,上滑显示
//        MyBehavior behavior = new MyBehavior();
//        params.setBehavior(behavior);

        fob = (FloatingActionButton)findViewById(R.id.fob);
        fob.setOnClickListener(this);

    }

    @Override
    public void onDismiss(View view) {

        view.setVisibility(View.GONE);

        Snackbar.make(view,"delect",Snackbar.LENGTH_LONG).setAction("back", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.VISIBLE);
               ViewCompat.animate(tv).alpha(1).start();

            }
        });
    }

    @Override
    public void onDragStateChanged(int state) {

    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,TextInputActivity.class));
    }
}
