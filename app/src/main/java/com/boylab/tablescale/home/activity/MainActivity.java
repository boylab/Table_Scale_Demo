package com.boylab.tablescale.home.activity;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.boylab.tablescale.base.modbus.data.WeightInfo;
import com.boylab.tablescale.base.modbus.master.SerialMaster;
import com.boylab.tablescale.base.modbus.socket.ModbusEngine;

public class MainActivity extends BaseActivity {

    private WeightInfo weightInfo = WeightInfo.info();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        ModbusEngine.instance().startEngine();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ModbusEngine.instance().stopEngine();
    }
}