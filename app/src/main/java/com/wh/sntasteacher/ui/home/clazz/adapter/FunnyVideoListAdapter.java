package com.wh.sntasteacher.ui.home.clazz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.sntasteacher.R;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class FunnyVideoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


     public FunnyVideoListAdapter(){
     }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funnt_video,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

    }
    @Override
    public int getItemCount() {
        return 8;
    }
     class ViewHolder extends RecyclerView.ViewHolder{
         ImageView iv_image;
         TextView tv_title;
         TextView tv_play_count;
         TextView tv_praise_num;
         TextView tv_comment_num;
         TextView tv_time;
         ImageView iv_share;
         ImageView iv_play;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            iv_play = (ImageView) itemView.findViewById(R.id.iv_play);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            tv_play_count = (TextView)itemView.findViewById(R.id.tv_play_count);
            tv_praise_num = (TextView)itemView.findViewById(R.id.tv_praise_num);
            tv_comment_num = (TextView)itemView.findViewById(R.id.tv_comment_num);
            tv_time = (TextView)itemView.findViewById(R.id.tv_time);
            iv_share = (ImageView)itemView.findViewById(R.id.iv_share);
            itemView.setTag(this);
        }
    }
}
