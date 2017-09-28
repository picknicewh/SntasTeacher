package com.wh.sntasteacher.ui.home.clazz.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;
import com.wh.sntasteacher.ui.home.clazz.adapter.FVideoCommentAdapter;
import com.wh.sntasteacher.ui.home.clazz.adapter.FunnyVideoAdapter;

import butterknife.BindView;
import butterknife.OnClick;

public class FunnyVideoDetailActivity extends BaseActivity {

    /**
     * 进度条
     */
    @BindView(R.id.sv_video)
    SurfaceView svVideo;
    /**
     * 分享
     */
    @BindView(R.id.iv_share)
    ImageView ivShare;
    /**
     * 播放
     */
    @BindView(R.id.iv_play_video)
    ImageView ivPlayVideo;
    /**
     * 播放进度条
     */
    @BindView(R.id.sb_progress)
    SeekBar sbProgress;
    /**
     * 全屏
     */
    @BindView(R.id.iv_full_screen)
    ImageView ivFullScreen;
    /**
     * 标题
     */
    @BindView(R.id.tv_title)
    TextView tvTitle;
    /**
     * 价格
     */
    @BindView(R.id.tv_price)
    TextView tvPrice;
    /**
     * 播放次数
     */
    @BindView(R.id.tv_play_count)
    TextView tvPlayCount;
    /**
     * 查看更多
     */
    @BindView(R.id.tv_more)
    TextView tvMore;
    /**
     * 推荐列表
     */
    @BindView(R.id.rv_recommend)
    RecyclerView rvRecommend;
    /**
     * 评论列表
     */
    @BindView(R.id.rv_comment)
    RecyclerView rvComment;
    /**
     * 推荐适配器
     */
    private FunnyVideoAdapter funnyVideoAdapter;
    /**
     * 评论适配器
     */
    private FVideoCommentAdapter commentAdapter;

    @Override
    public void setTop() {
        isHideNavigation(true);
    }

    @Override
    public void initData() {
        commentAdapter = new FVideoCommentAdapter();
        rvComment.setLayoutManager(new LinearLayoutManager(this));
        rvComment.setAdapter(commentAdapter);
        funnyVideoAdapter = new FunnyVideoAdapter(this);
        rvRecommend.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvRecommend.setAdapter(funnyVideoAdapter);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_funny_video_detail;
    }


    @OnClick(R.id.iv_back)
    public void back() {
        finish();
    }
}
