package com.wh.sntasteacher.ui.home.clazz.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.util.G;
import com.wh.sntasteacher.widget.CircleImageView;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class GoodTeacherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

     private Activity context;
     public GoodTeacherAdapter(Activity context){
       this.context = context;
         G.initDisplaySize(context);
     }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_good_teacher,null);
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
         TextView tv_teacher_info;
        public ViewHolder(View itemView) {
            super(itemView);
            civ_image = (CircleImageView) itemView.findViewById(R.id.civ_image);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_teacher_info = (TextView)itemView.findViewById(R.id.tv_teacher_info);
            int width = (G.size.W-G.dp2px(context,80))/4;
            G.log("xxxxxxc"+width);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.CENTER;
            tv_teacher_info.setGravity(Gravity.CENTER);
            tv_teacher_info.setLayoutParams(lp);
            itemView.setTag(this);
        }
    }
}
