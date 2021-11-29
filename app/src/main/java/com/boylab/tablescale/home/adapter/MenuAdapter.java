package com.boylab.tablescale.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.boylab.tablescale.R;
import com.boylab.tablescale.home.bean.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {

    private Context context;
    private List<MenuItem> menuList = null;

    private AdapterView.OnItemClickListener onItemClickListener;

    public MenuAdapter(Context context, List<MenuItem> menuList) {
        this.context = context;
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_menu, null);
        return new MyViewHolder(rootView);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MenuItem menuItem = menuList.get(position);
        holder.image_Menu.setBackgroundResource(menuItem.getImgRes());
        holder.text_Menu.setText(menuItem.getText());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = (int) view.getTag();
                if (onItemClickListener != null){
                    onItemClickListener.onItemClick(null, view, index, view.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_Menu;
        private TextView text_Menu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image_Menu = itemView.findViewById(R.id.image_Menu);
            text_Menu = itemView.findViewById(R.id.text_Menu);
        }
    }
}
