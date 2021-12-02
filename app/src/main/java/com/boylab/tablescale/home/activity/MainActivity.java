package com.boylab.tablescale.home.activity;

import android.serialport.SerialPort;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button btn_MenuFunc, btn_Record, btn_Print, btn_Tare, btn_Zero;

    private WeightInfo weightInfo = WeightInfo.info();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        scaleView = findViewById(R.id.scaleView);
        btn_MenuFunc = findViewById(R.id.btn_MenuFunc);
        btn_Record = findViewById(R.id.btn_Record);
        btn_Print = findViewById(R.id.btn_Print);
        btn_Tare = findViewById(R.id.btn_Tare);
        btn_Zero = findViewById(R.id.btn_Zero);
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