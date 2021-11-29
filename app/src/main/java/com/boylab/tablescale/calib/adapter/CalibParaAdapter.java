package com.boylab.tablescale.calib.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.utils.ViewClick;
import com.boylab.tablescale.calib.bean.ParaUnit;
import com.github.gzuliyujiang.wheelpicker.OptionPicker;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionPickedListener;
import com.github.gzuliyujiang.wheelpicker.contract.OnOptionSelectedListener;
import com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout;
import com.github.gzuliyujiang.wheelview.annotation.CurtainCorner;

import java.util.ArrayList;
import java.util.List;

public class CalibParaAdapter extends RecyclerView.Adapter<CalibParaAdapter.MyViewHolder> implements OnOptionPickedListener {

    private Activity context;

    private List<ParaUnit> paraList = new ArrayList<ParaUnit>(){{
        add(new ParaUnit("参数1", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数2", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数3", ParaUnit.INPUT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数4", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数5", ParaUnit.INPUT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数6", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数7", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数8", ParaUnit.INPUT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数9", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数10", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数11", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数12", ParaUnit.SELECT, 0, new String[]{"", ""}));
        add(new ParaUnit("参数13", ParaUnit.SELECT, 0, new String[]{"", ""}));
    }};

    private List<Integer> calibPara ;
    private AdapterView.OnItemClickListener onItemClickListener;
    private int selectUnit = 0;

    public CalibParaAdapter(Activity context, List<Integer> calibPara) {
        this.context = context;
        this.calibPara = calibPara;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_calibpara, null);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ParaUnit paraUnit = paraList.get(position);

        holder.text_ParaLabel.setText(paraUnit.getLabel());
        if (paraUnit.getAction() == ParaUnit.INPUT){
            holder.text_ParaValue.setText(String.valueOf(paraUnit.getValue()));
        }else {
            holder.text_ParaValue.setText(paraUnit.getSelectValues());
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


                    notifyItemChanged(selectUnit);
                }else {
                    float density = view.getResources().getDisplayMetrics().scaledDensity;
                    showWheel(paraUnit, density);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return paraList.size();
    }

    private void showWheel(ParaUnit paraUnit, float density){
        OptionPicker picker = new OptionPicker(context);
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
                picker.getTitleView().setText(picker.getWheelView().formatItem(position));
            }
        });
        picker.show();
    }

    @Override
    public void onOptionPicked(int position, Object item) {
        /**
         * 选择的结果
         */
        paraList.get(selectUnit).setValue(position);
        notifyItemChanged(selectUnit);
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
