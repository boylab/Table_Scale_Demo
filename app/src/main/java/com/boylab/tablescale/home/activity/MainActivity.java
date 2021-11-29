package com.boylab.tablescale.home.activity;

import android.serialport.SerialPort;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.boylab.tablescale.base.modbus.data.WeightInfo;
import com.boylab.tablescale.base.modbus.master.SerialMaster;
import com.boylab.tablescale.base.modbus.socket.Command;
import com.boylab.tablescale.base.modbus.socket.ModbusEngine;
import com.boylab.tablescale.base.view.ScaleView;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.msg.ReadInputRegistersResponse;

public class MainActivity extends BaseActivity {

    private ScaleView scaleView;

    private WeightInfo weightInfo = WeightInfo.info();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        scaleView = findViewById(R.id.scaleView);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onStart() {
        ModbusEngine.instance().startEngine();
        super.onStart();
    }

    @Override
    protected void onFreshView(int what, ModbusResponse response) {
        if (what == Command.readInfo){
            scaleView.freshWeight(weightInfo);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ModbusEngine.instance().stopEngine();
    }
}