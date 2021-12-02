package com.boylab.tablescale.calib.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.utils.Config;
import com.boylab.tablescale.base.utils.ViewClick;
import com.boylab.tablescale.calib.bean.ParaUnit;
import com.github.gzuliyujiang.wheelpicker.NumberPicker;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.github.gzuliyujiang.wheelpicker.contract.OnNumberPickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnNumberSelectedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelview.annotation.CurtainCorner;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;

import java.util.List;

public class CalibParaAdapter extends RecyclerView.Adapter<CalibParaAdapter.MyViewHolder> implements OnOptionPickedListener, OnNumberPickedListener {

    private Activity mActivity;
    private List<ParaUnit> paraList = null;

    private AdapterView.OnItemClickListener onItemClickListener;
    private int selectUnit = 0;

    public CalibParaAdapter(Activity mActivity, List<ParaUnit> paraList) {
        this.mActivity = mActivity;
        this.paraList = paraList;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.item_calibpara, null);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ParaUnit paraUnit = paraList.get(position);
        holder.text_ParaLabel.setText(paraUnit.getLabel());
        if (paraUnit.getAction() == ParaUnit.INPUT){
            int point = paraList.get(1).getValue();
            String unit = Config.UNIT[paraList.get(2).getValue()];
            String fullScale = String.format("%6."+point+"f ", paraUnit.getValue()/Math.pow(10, point)) + unit;
            holder.text_ParaValue.setText(fullScale);
        }else {
            if (position == 0){
                holder.text_ParaValue.setText(String.valueOf(paraUnit.getValue()));
            }else if (position == 7 || position == 8){
                holder.text_ParaValue.setText(String.format("%d %%", paraUnit.getValue()));
            }else {
                holder.text_ParaValue.setText(paraUnit.getSelectValues());
            }
        }
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ViewClick.isFastClick()){
                    return;
                }
                selectUnit = (int) view.getTag();
                ParaUnit paraUnit = paraList.get(position);
                if (paraUnit.getAction() == ParaUnit.INPUT){
                    // TODO: 2021/11/30 输入数值




                    notifyDataSetChanged();
                }else {
                    if (selectUnit == 7 || selectUnit == 8){
                        showNumberWheel(paraUnit);
                    }else {
                        float density = view.getResources().getDisplayMetrics().scaledDensity;
                        showWheel(paraUnit, density);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return paraList.size();
    }

    public void showNumberWheel(ParaUnit paraUnit) {
        NumberPicker picker = new NumberPicker(mActivity);
        picker.setOnNumberPickedListener(CalibParaAdapter.this);
        picker.getWheelLayout().setOnNumberSelectedListener(new OnNumberSelectedListener() {
            @Override
            public void onNumberSelected(int position, Number item) {
                picker.getTitleView().setText(paraUnit.getLabel() +" ( "+ picker.getWheelView().formatItem(position)+" ) ");
            }
        });
        picker.setFormatter(new WheelFormatter() {
            @Override
            public String formatItem(@NonNull Object item) {
                return item.toString() + " %";
            }
        });
        picker.setRange(0, 100, 1);
        picker.setDefaultValue(paraUnit.getValue());
        picker.setTitle("身高选择");
        picker.show();
    }

    private void showWheel(ParaUnit paraUnit, float density){
        OptionPicker picker = new OptionPicker(mActivity);
        picker.setTitle(paraUnit.getLabel());
        picker.setBodyWidth(140);
        picker.setData(paraUnit.getShowValues());
        picker.setDefaultPosition(paraUnit.getValue());
        picker.setOnOptionPickedListener(CalibParaAdapter.this);
        OptionWheelLayout wheelLayout = picker.getWheelLayout();
        wheelLayout.setIndicatorEnabled(false);
        wheelLayout.setTextColor(0xFFFF00FF);
        wheelLayout.setSelectedTextColor(0xFFFF0000);
        wheelLayout.setTextSize(15 * density);
        //注：建议通过`setStyle`定制样式设置文字加大，若通过`setSelectedTextSize`设置，该解决方案会导致选择器展示时跳动一下
        //wheelLayout.setStyle(R.style.WheelStyleDemo);
        wheelLayout.setSelectedTextSize(17 * density);
        wheelLayout.setSelectedTextBold(true);
        wheelLayout.setCurtainEnabled(true);
        wheelLayout.setCurtainColor(0xEEFF0000);
        wheelLayout.setCurtainCorner(CurtainCorner.ALL);
        wheelLayout.setCurtainRadius(5 * density);
        wheelLayout.setOnOptionSelectedListener(new OnOptionSelectedListener() {
            @Override
            public void onOptionSelected(int position, Object item) {
                picker.getTitleView().setText(paraUnit.getLabel() +" ( "+ picker.getWheelView().formatItem(position)+" ) ");
            }
        });
        picker.show();
    }

    @Override
    public void onOptionPicked(int position, Object item) {
        paraList.get(selectUnit).setValue(position);
        notifyDataSetChanged();
    }

    @Override
    public void onNumberPicked(int position, Number item) {
        paraList.get(selectUnit).setValue(position);
        notifyDataSetChanged();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView text_ParaLabel, text_ParaValue;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text_ParaLabel = itemView.findViewById(R.id.text_ParaLabel);
            text_ParaValue = itemView.findViewById(R.id.text_ParaValue);
        }
    }
}
