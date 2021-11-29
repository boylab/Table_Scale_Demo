package com.boylab.tablescale.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.boylab.tablescale.R;

public class WeightView extends RelativeLayout {

    private TextView tv_Weight_Label, tv_Weight_Unit;
    private DigitalTextView tv_Weight_Show;

    public WeightView(Context context) {
        super(context);
        initView(context);
    }

    public WeightView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public WeightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View rootView = View.inflate(context, R.layout.layout_weight_view, this);

        tv_Weight_Label = rootView.findViewById(R.id.tv_Weight_Label);
        tv_Weight_Show = rootView.findViewById(R.id.tv_Weight_Show);
        tv_Weight_Unit = rootView.findViewById(R.id.tv_Weight_Unit);
    }

    protected void toNetView() {
        tv_Weight_Label.setTextSize(30);
        tv_Weight_Show.setTextSize(100);
        tv_Weight_Unit.setTextSize(50);
        tv_Weight_Label.setText("净重");
    }

    protected void toGrossOrTare(String label) {
        tv_Weight_Label.setTextSize(20);
        tv_Weight_Show.setTextSize(50);
        tv_Weight_Unit.setTextSize(20);
        tv_Weight_Label.setText(label);
    }

    public void freshWeight(String weight, String unit){
        tv_Weight_Show.setText(weight);
        tv_Weight_Unit.setText(unit);
    }

}
