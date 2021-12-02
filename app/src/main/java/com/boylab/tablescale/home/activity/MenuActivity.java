package com.boylab.tablescale.home.activity;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.base.activity.BaseActivity;
import com.boylab.tablescale.base.utils.RecyclerUtil;
import com.boylab.tablescale.base.utils.ViewClick;
import com.boylab.tablescale.calib.activity.CalibParaActivity;
import com.boylab.tablescale.calib.activity.CalibWeightActivity;
import com.boylab.tablescale.home.adapter.MenuAdapter;
import com.boylab.tablescale.home.bean.MenuItem;
import com.serotonin.modbus4j.msg.ModbusResponse;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private RecyclerView rv_Menu;
    private MenuAdapter menuAdapter;
    private List<MenuItem> menuList = new ArrayList<MenuItem>(){{
        add(new MenuItem(R.drawable.ic_launcher_background, "用户管理", null));
        add(new MenuItem(R.drawable.ic_launcher_background, "标定参数", CalibParaActivity.class));
        add(new MenuItem(R.drawable.ic_launcher_background, "标定", CalibWeightActivity.class));
    }};

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_menu);
    }

    @Override
    protected void initView() {
        rv_Menu = findViewById(R.id.rv_Menu);
        rv_Menu.setLayoutManager(RecyclerUtil.gridLayoutManager(this, 4));
        rv_Menu.addItemDecoration(RecyclerUtil.gridDivider(Color.GRAY));
    }

    @Override
    protected void initData() {
        menuAdapter = new MenuAdapter(this, menuList);
        rv_Menu.setAdapter(menuAdapter);
        menuAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (ViewClick.isFastClick()){
            return;
        }
        MenuItem menuItem = menuList.get(i);
        if (menuItem.getClazz() != null){
            Intent intent = new Intent(this, menuItem.getClazz());
            startActivity(intent);
        }
    }

    @Override
    protected void onFreshView(int what, ModbusResponse response) {

    }

}