package com.wh.sntasteacher.ui.home.clazz.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseFragment;
import com.wh.sntasteacher.ui.home.clazz.adapter.AllCourseAdapter;

import butterknife.BindView;

/**
 * 作者： wh
 * 时间：  2017/9/27
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class RecommendVideoFragment extends BaseFragment {
    @BindView(R.id.rv_course)
    RecyclerView rvCourse;
    private AllCourseAdapter allCourseAdapter;
    @Override
    public void setTop() {
        isHideNavigation(true);
    }

    @Override
    public void initData() {
        allCourseAdapter = new AllCourseAdapter();
        rvCourse.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCourse.setAdapter(allCourseAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recommend_video;
    }

}
