package com.desgin.srdz.desgindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    private Button mBtn1Button;
    private Button mBtn2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtn1Button = (Button) findViewById(R.id.btn1);
        mBtn2Button = (Button) findViewById(R.id.btn2);


    }
}
