package com.boylab.tablescale.calib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.boylab.tablescale.base.modbus.data.WeightInfo;
import com.boylab.tablescale.base.modbus.socket.Command;
import com.boylab.tablescale.base.utils.Config;
import com.serotonin.modbus4j.msg.ModbusResponse;

public class CalibWeightActivity extends BaseActivity implements View.OnClickListener {

    private TextView text_Weight, text_WeigherCode;
    private TextView tv_Input_Weight;
    private Button btn_Calib_Zero, btn_Input_Weight, btn_Calib_Weight, btn_Calib_PreStep;

    private int calibStep = 0;
    private int calibWeight;
    private WeightInfo weightInfo = WeightInfo.info();

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_calib_weight);
    }

    @Override
    protected void initView() {
        text_Weight = findViewById(R.id.text_Weight);
        text_WeigherCode = findViewById(R.id.text_WeigherCode);
        tv_Input_Weight = findViewById(R.id.tv_Input_Weight);
        btn_Calib_Zero = findViewById(R.id.btn_Calib_Zero);
        btn_Input_Weight = findViewById(R.id.btn_Input_Weight);
        btn_Calib_Weight = findViewById(R.id.btn_Calib_Weight);
        btn_Calib_PreStep = findViewById(R.id.btn_Calib_PreStep);
        tv_Input_Weight.setOnClickListener(this);
        btn_Calib_Zero.setOnClickListener(this);
        btn_Input_Weight.setOnClickListener(this);
        btn_Calib_Weight.setOnClickListener(this);
        btn_Calib_PreStep.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onFreshView(int what, ModbusResponse response) {
        if (what == Command.readInfo){
            text_Weight.setText(weightInfo.grossFormat() + Config.UNIT[weightInfo.weighSign1().getUnit()]);

            text_WeigherCode.setText(String.valueOf(weightInfo.getGrossCode()));
        }
    }

    @Override
    public void onClick(View view) {
        int clickId = view.getId();
        if (clickId == R.id.btn_Calib_Zero){
            // TODO: 2021/11/30 标定零点
            freshCalibStep(1);
        }else if (clickId == R.id.tv_Input_Weight){

        }else if (clickId == R.id.btn_Input_Weight){
            // TODO: 2021/11/30 判断输入重量是否符合条件
            
            freshCalibStep(2);
        }else if (clickId == R.id.btn_Calib_Weight){
            // TODO: 2021/11/30 标定重量
            
        }else if (clickId == R.id.btn_Calib_PreStep){
            int step = (calibStep > 0 ? calibStep - 1 : 0);
            freshCalibStep(step);
        }
    }

    private void freshCalibStep(int step){
        calibStep = step;
        if (calibStep == 0){
            calibWeight = 0;
        }
        btn_Calib_Zero.setEnabled(calibStep == 0? true : false);
        tv_Input_Weight.setEnabled(calibStep >= 1? true : false);
        btn_Input_Weight.setEnabled(calibStep == 1? true : false);
        btn_Calib_Weight.setEnabled(calibStep == 2? true : false);
        btn_Calib_PreStep.setEnabled(calibStep >= 1? true : false);

        btn_Calib_Zero.setClickable(calibStep == 0? true : false);
        tv_Input_Weight.setClickable(calibStep >= 1? true : false);
        btn_Input_Weight.setClickable(calibStep == 1? true : false);
        btn_Calib_Weight.setClickable(calibStep == 2? true : false);
        btn_Calib_PreStep.setClickable(calibStep >= 1? true : false);

        btn_Calib_Zero.setAlpha(calibStep == 0? 1f : 0.5f);
        tv_Input_Weight.setAlpha(calibStep >= 1? 1f : 0.5f);
        btn_Input_Weight.setAlpha(calibStep == 1? 1f : 0.5f);
        btn_Calib_Weight.setAlpha(calibStep == 2? 1f : 0.5f);
        btn_Calib_PreStep.setAlpha(calibStep >= 1? 1f : 0.5f);
    }
}