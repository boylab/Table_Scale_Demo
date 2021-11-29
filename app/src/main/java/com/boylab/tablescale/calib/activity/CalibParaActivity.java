package com.boylab.tablescale.calib.activity;

import android.graphics.Color;

import androidx.recyclerview.widget.RecyclerView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.boylab.tablescale.base.utils.RecyclerUtil;
import com.serotonin.modbus4j.msg.ModbusResponse;

public class CalibParaActivity extends BaseActivity {

    private RecyclerView rv_CalibPara;

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_calib_para);
    }

    @Override
    protected void initView() {
        rv_CalibPara = findViewById(R.id.rv_CalibPara);
        rv_CalibPara.setLayoutManager(RecyclerUtil.gridLayoutManager(this, 2));
        rv_CalibPara.addItemDecoration(RecyclerUtil.gridDivider( Color.GRAY));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onFreshView(int what, ModbusResponse response) {

    }
}