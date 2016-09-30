package com.desgin.srdz.desgindemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

public class TextInputActivity extends AppCompatActivity implements TextWatcher {

    TextInputLayout text_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        text_input = (TextInputLayout)findViewById(R.id.text_input);
        text_input.getEditText().addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length()<6){
            text_input.setError("用户名必须为6位以上");
            text_input.setErrorEnabled(true);
        }else {
            text_input.setErrorEnabled(false);
        }
    }
}
