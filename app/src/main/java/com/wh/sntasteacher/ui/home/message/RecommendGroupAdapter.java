package com.wh.sntasteacher.ui.home.message;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.widget.CircleImageView;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class RecommendGroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

     public RecommendGroupAdapter(){

     }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend_group,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

    }
    @Override
    public int getItemCount() {
        return 4;
    }
     class ViewHolder extends RecyclerView.ViewHolder{
         CircleImageView civ_image;
          TextView tv_name;
        public ViewHolder(View itemView) {
            super(itemView);
            civ_image = (CircleImageView) itemView.findViewById(R.id.civ_image);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            itemView.setTag(this);
        }
    }
}
