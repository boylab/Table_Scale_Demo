package com.boylab.tablescale.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.boylab.tablescale.R;

public class WeightStatus extends RelativeLayout {

    private ImageView iv_Zero_Status, iv_Tare_Status, iv_Stable_Status;

    public WeightStatus(Context context) {
        super(context);
        initView(context);
    }

    public WeightStatus(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public WeightStatus(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View rootView = View.inflate(context, R.layout.layout_weight_status, this);

        iv_Zero_Status = rootView.findViewById(R.id.iv_Zero_Status);
        iv_Tare_Status = rootView.findViewById(R.id.iv_Tare_Status);
        iv_Stable_Status = rootView.findViewById(R.id.iv_Stable_Status);
    }

    public void freshState(boolean isZero, boolean isTare, boolean isStable) {
        iv_Zero_Status.setVisibility(isZero ? VISIBLE : INVISIBLE);
        iv_Tare_Status.setVisibility(isTare ? VISIBLE : INVISIBLE);
        iv_Stable_Status.setVisibility(isStable ? VISIBLE : INVISIBLE);
    }
}
