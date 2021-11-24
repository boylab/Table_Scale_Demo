package com.boylab.tablescale.base.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView();
            initView();
            initData();
        }catch (Exception e){
            System.err.println("onCreate() has Error !");
        }
    }

    protected abstract void setContentView();
    protected abstract void initView();
    protected abstract void initData();
}
