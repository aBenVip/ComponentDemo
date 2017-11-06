package com.dgcredit.customcomponent;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/18
 * 备注:
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorizontalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.customcomponent_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder{
        public HorizontalViewHolder(View itemView) {
            super(itemView);
        }
    }
}
