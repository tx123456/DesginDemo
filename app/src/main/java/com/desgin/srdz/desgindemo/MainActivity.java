package com.desgin.srdz.desgindemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    TabLayout lay_tab;
    ViewPager pager;
    List<String> list;
    Toolbar toolbar;
    DrawerLayout lay_drawer;
    NavigationView lay_navigation;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, lay_drawer, toolbar, 0, 0);
        lay_drawer.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(String.format(Locale.CHINA, "第%02d页", i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(), list));
        lay_tab.setupWithViewPager(pager);
    }

    private void initView() {
        lay_tab = (TabLayout) findViewById(R.id.lay_tab);
        pager = (ViewPager) findViewById(R.id.pager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        lay_drawer = (DrawerLayout) findViewById(R.id.lay_draw);
        lay_navigation = (NavigationView) findViewById(R.id.lay_navigation);
        lay_navigation.setNavigationItemSelectedListener(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item1:

                break;
            case R.id.item2:

                break;
            case R.id.item3:

                break;
            case R.id.item4:
                finish();
                break;
        }
        lay_drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Snackbar", Snackbar.LENGTH_SHORT).setAction("undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this, CoordinatorActivity.class));
            }
        }).show();
    }
}
