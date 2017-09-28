package com.wh.sntasteacher.ui.home.clazz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.util.OnItemClickListener;
import com.wh.sntasteacher.widget.CircleImageView;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class FVideoCommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     private OnItemClickListener onItemClickListener;
     public FVideoCommentAdapter(){

     }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funny_video_comment,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (onItemClickListener!=null){
                   onItemClickListener.onClick(v,position);
               }
           }
       });
    }
    @Override
    public int getItemCount() {
        return 10;
    }
     class ViewHolder extends RecyclerView.ViewHolder{
         CircleImageView civ_image;
          ImageView iv_praise;
         TextView tv_name;
         TextView tv_comment_content;
         TextView tv_time;
        public ViewHolder(View itemView) {
            super(itemView);
            civ_image = (CircleImageView) itemView.findViewById(R.id.civ_image);
            iv_praise = (ImageView) itemView.findViewById(R.id.iv_praise);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_comment_content = (TextView)itemView.findViewById(R.id.tv_comment_content) ;
            tv_time = (TextView)itemView.findViewById(R.id.tv_time);
            itemView.setTag(this);
        }
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
