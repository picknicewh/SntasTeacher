package com.wh.sntasteacher.ui.home.clazz.adapter;

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
public class TeacherListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


     public TeacherListAdapter(){
     }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teacher_list,null);
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
         CircleImageView civ_image;
         TextView tv_name;
         TextView tv_teacher_title;
         TextView tv_teacher_school;
         TextView tv_fans;
         TextView tv_attention;
         TextView tv_read_courses;
        public ViewHolder(View itemView) {
            super(itemView);
            civ_image = (CircleImageView) itemView.findViewById(R.id.civ_image);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_teacher_title = (TextView)itemView.findViewById(R.id.tv_teacher_title);
            tv_fans = (TextView)itemView.findViewById(R.id.tv_fans);
            tv_attention = (TextView)itemView.findViewById(R.id.tv_attention);
            tv_teacher_school = (TextView)itemView.findViewById(R.id.tv_teacher_school);
            tv_read_courses = (TextView)itemView.findViewById(R.id.tv_read_course);
            itemView.setTag(this);
        }
    }
}
