package com.wh.sntasteacher.ui.home.clazz.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.util.OnItemClickListener;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class AllCourseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     private OnItemClickListener onItemClickListener;
     public AllCourseAdapter(){

     }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_course,null);
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
         ImageView iv_image;
          TextView tv_price;
         TextView tv_title;
         TextView tv_teacher;
         TextView tv_study;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            tv_price = (TextView) itemView.findViewById(R.id.tv_class_time);
            tv_title = (TextView)itemView.findViewById(R.id.tv_class_title);
            tv_teacher = (TextView)itemView.findViewById(R.id.tv_class_teacher) ;
            tv_study = (TextView)itemView.findViewById(R.id.tv_class_study);
            itemView.setTag(this);
        }
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
