package com.boylab.tablescale.base.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.modbus.data.WeighSign1;
import com.boylab.tablescale.base.modbus.data.WeightInfo;
import com.boylab.tablescale.base.utils.Config;

public class ScaleView extends RelativeLayout {

    private WeightView view_Net_Weight, view_Gross_Weight, view_Tare_Weight;
    private WeightStatus weight_Status;
    private int mUnit = 0;

    public ScaleView(Context context, AttributeSet ats, int defStyle) {
        super(context, ats, defStyle);
        initView(context);
    }

    public ScaleView(Context context, AttributeSet ats) {
        super(context, ats);
        initView(context);
    }

    public ScaleView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View rootView = View.inflate(context, R.layout.layout_scale_view, this);

        view_Net_Weight = rootView.findViewById(R.id.view_Net_Weight);
        view_Gross_Weight = rootView.findViewById(R.id.view_Gross_Weight);
        view_Tare_Weight = rootView.findViewById(R.id.view_Tare_Weight);
        weight_Status = rootView.findViewById(R.id.weight_Status);

        view_Net_Weight.toNetView();
        view_Gross_Weight.toGrossOrTare("毛重");
        view_Tare_Weight.toGrossOrTare("皮重");
    }

    public void freshWeight(WeightInfo weightInfo){
        WeighSign1 weighSign1 = weightInfo.weighSign1();
        String unit = Config.UNIT[weighSign1.getUnit()];
        view_Net_Weight.freshWeight(weightInfo.netFormat(), unit);
        view_Gross_Weight.freshWeight(weightInfo.grossFormat(), unit);
        view_Tare_Weight.freshWeight(weightInfo.tareFormat(), unit);
        weight_Status.freshState(weighSign1.isZero(), weighSign1.isTare(), weighSign1.isStable());
    }

}
