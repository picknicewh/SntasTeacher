package com.wh.sntasteacher.ui.home.clazz.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.util.G;
import com.wh.sntasteacher.util.OnItemClickListener;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class FunnyVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  Activity context;
     public FunnyVideoAdapter(Activity context){
     this.context = context;
         G.initDisplaySize(context);
     }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_funny_video,null);
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
        return 5;
    }
     class ViewHolder extends RecyclerView.ViewHolder{
         ImageView iv_image;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            int width = G.size.W/2-G.dp2px(context,10);
            int height = G.dp2px(context,80);
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(width,height);
            lp.setMargins(0,0,G.dp2px(context,10),0);
            lp.addRule( Gravity.CENTER);
            iv_image.setLayoutParams(lp);
            itemView.setTag(this);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
