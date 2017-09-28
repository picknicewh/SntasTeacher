package com.wh.sntasteacher.ui.home.circle;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.util.G;
import com.wh.sntasteacher.util.PictrueUtils;
import com.wh.sntasteacher.widget.CircleImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者： wh
 * 时间：  2017/6/24
 * 名称：搜索适配器
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class StudyCircleAdapter extends RecyclerView.Adapter<StudyCircleAdapter.ViewHolder> {

    private  Activity context;
     public StudyCircleAdapter(Activity context){
     this.context = context;
         G.initDisplaySize(context);
     }

    @Override
    public StudyCircleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_study_circle,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudyCircleAdapter.ViewHolder holder, final int position) {
        List<String> images= getimages().get(position);
       holder.pictrueUtils.setPictrueLoad(context,images,holder.rl_picture);
    }
  private   List<List<String>> getimages(){
      List<List<String>> images= new ArrayList<>();
      for (int i = 0 ;i<5;i++){
          List<String> image = new ArrayList<>();
          for (int j = 0 ;j< G.netImageList.length;j++){
              if (i==0 && j<1){
                  image.add(G.netImageList[j]);
                  break;
              }else if (i==1&&j<4){
                  image.add(G.netImageList[j]);
              }else if (i==2){
                  image.add(G.netImageList[j]);
              }else if (i==3&&j<4){
                  image.add(G.netImageList[j]);

              }else if (i==4&&j<3){
                  image.add(G.netImageList[j]);
              }

          }
          images.add                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              (image);
      }
      return images;
  }
    @Override
    public int getItemCount() {
        return 5;
    }
     class ViewHolder extends RecyclerView.ViewHolder{
         CircleImageView civ_image;
         TextView tv_name;
         TextView tv_content;
         RelativeLayout rl_picture;
         TextView tv_time;
         TextView tv_delete;
         TextView tv_praise_num;
         TextView tv_comment_num;
         PictrueUtils pictrueUtils;
        public ViewHolder(View itemView) {
            super(itemView);
            pictrueUtils = new PictrueUtils();
            civ_image = (CircleImageView) itemView.findViewById(R.id.cv_head);
            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_content = (TextView)itemView.findViewById(R.id.tv_content);
            rl_picture = (RelativeLayout)itemView.findViewById(R.id.rl_picture);
            tv_time = (TextView)itemView.findViewById(R.id.tv_time);
            tv_delete = (TextView)itemView.findViewById(R.id.tv_delete);
            tv_praise_num = (TextView)itemView.findViewById(R.id.tv_praise_num);
            tv_comment_num = (TextView)itemView.findViewById(R.id.tv_comment_num);
            itemView.setTag(this);
        }
    }
}
