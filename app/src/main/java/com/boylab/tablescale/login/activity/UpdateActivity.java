package com.boylab.tablescale.login.activity;

import android.os.Bundle;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.serotonin.modbus4j.msg.ModbusResponse;

public class UpdateActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_update);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onFreshView(int what, ModbusResponse response) {

    }
}