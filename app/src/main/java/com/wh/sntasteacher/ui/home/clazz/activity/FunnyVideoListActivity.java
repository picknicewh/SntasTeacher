package com.wh.sntasteacher.ui.home.clazz.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;
import com.wh.sntasteacher.ui.home.clazz.adapter.FunnyVideoListAdapter;

import butterknife.BindView;

public class FunnyVideoListActivity extends BaseActivity {

    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    private FunnyVideoListAdapter adapter;
    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setLeftImage(R.mipmap.ic_back);
        setRightImage(R.mipmap.ic_search);
        setTitle("趣视屏");
        adapter =new FunnyVideoListAdapter();
        rvVideo.setLayoutManager(new LinearLayoutManager(this));
        rvVideo.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_funny_video_list;
    }

}
