package com.boylab.tablescale.base.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.boylab.tablescale.base.modbus.data.WeightInfo;
import com.boylab.tablescale.base.modbus.socket.ModbusEngine;
import com.boylab.tablescale.base.modbus.socket.ModbusListener;
import com.serotonin.modbus4j.msg.ModbusResponse;
import com.serotonin.modbus4j.msg.ReadCoilsResponse;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import com.serotonin.modbus4j.msg.ReadInputRegistersResponse;

public abstract class BaseActivity extends AppCompatActivity implements ModbusListener {

    protected volatile ModbusEngine modbusEngine = ModbusEngine.instance();

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

    protected abstract void onFreshView(int what, ModbusResponse response);

    @Override
    protected void onStart() {
        super.onStart();
        if (modbusEngine.isStart()){
            modbusEngine.setOnModbusResponse(this);
        }
    }

    @Override
    public void onResponse(int what, ModbusResponse response) {
        /**
         * ReadCoilsResponse
         * ReadHoldingRegistersResponse
         * ReadInputRegistersResponse
         *
         * WriteCoilResponse
         * WriteCoilsResponse
         *
         * WriteRegisterResponse
         * WriteRegistersResponse
         *
         */
        if (response instanceof ReadInputRegistersResponse){
            ReadInputRegistersResponse inputResponse = (ReadInputRegistersResponse) response;
            byte[] data = inputResponse.getData();
            WeightInfo.info().toInfo(data);
        }else if (response instanceof ReadHoldingRegistersResponse){
            ReadHoldingRegistersResponse holdingResponse = (ReadHoldingRegistersResponse) response;
            // TODO: 2021/11/26
        }else if (response instanceof ReadCoilsResponse){
            ReadCoilsResponse coilsResponse = (ReadCoilsResponse) response;
            // TODO: 2021/11/26
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onFreshView(what, response);
            }
        });
    }
}
