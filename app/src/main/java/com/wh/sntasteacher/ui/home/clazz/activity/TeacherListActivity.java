package com.wh.sntasteacher.ui.home.clazz.activity;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;
import com.wh.sntasteacher.ui.home.clazz.adapter.TeacherListAdapter;

import butterknife.BindView;

public class TeacherListActivity extends BaseActivity {


    @BindView(R.id.rv_teacher)
    RecyclerView rvTeacher;
    private TeacherListAdapter adapter;
    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setLeftImage(R.mipmap.ic_back);
        setTitle("优秀讲师");
        setRightImage(R.mipmap.ic_search);
        adapter =new TeacherListAdapter();
        rvTeacher.setLayoutManager(new LinearLayoutManager(this));
    rvTeacher.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_teacher_list;
    }
}
