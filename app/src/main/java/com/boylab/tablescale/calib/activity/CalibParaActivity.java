package com.boylab.tablescale.calib.activity;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;

import androidx.recyclerview.widget.RecyclerView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.boylab.tablescale.base.utils.Config;
import com.boylab.tablescale.base.utils.RecyclerUtil;
import com.boylab.tablescale.calib.adapter.CalibParaAdapter;
import com.boylab.tablescale.calib.bean.ParaUnit;
import com.serotonin.modbus4j.msg.ModbusResponse;

import java.util.ArrayList;
import java.util.List;

public class CalibParaActivity extends BaseActivity {

    private RecyclerView rv_CalibPara;
    private CalibParaAdapter calibParaAdapter;
    private List<ParaUnit> paraList = new ArrayList<ParaUnit>(){{
        add(0, new ParaUnit("分度值", ParaUnit.SELECT, 0, Config.DIV));
        add(1, new ParaUnit("小数点", ParaUnit.SELECT, 2, Config.POINT));
        add(2, new ParaUnit("重量单位", ParaUnit.SELECT, 0, Config.UNIT));
        add(3, new ParaUnit("满量程值", ParaUnit.INPUT, 5203, null));
        add(4, new ParaUnit("滤波模式", ParaUnit.SELECT, 0, Config.FilterMode));
        add(5, new ParaUnit("滤波强度", ParaUnit.SELECT, 0, Config.FilterLevel));
        add(6, new ParaUnit("判稳范围", ParaUnit.SELECT, 0, Config.StableRange));
        add(7, new ParaUnit("开机置零范围", ParaUnit.SELECT, 0, null));
        add(8, new ParaUnit("手动置零范围", ParaUnit.SELECT, 0, null));
        add(9, new ParaUnit("零点跟踪模式", ParaUnit.SELECT, 0, Config.ZeroMode));
        add(10,new ParaUnit("零点跟踪范围", ParaUnit.SELECT, 0, Config.ZeroRange));
        add(11,new ParaUnit("零点跟踪速度", ParaUnit.SELECT, 0, Config.ZeroSpeed));
        add(12,new ParaUnit("补偿模式", ParaUnit.SELECT, 0, Config.Compensate));
    }};

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
        calibParaAdapter = new CalibParaAdapter(this, paraList);
        rv_CalibPara.setAdapter(calibParaAdapter);
    }

    @Override
    protected void onFreshView(int what, ModbusResponse response) {

    }
}