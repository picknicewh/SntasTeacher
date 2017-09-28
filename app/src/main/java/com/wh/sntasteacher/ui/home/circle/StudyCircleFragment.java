package com.wh.sntasteacher.ui.home.circle;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseFragment;

import butterknife.BindView;

public class StudyCircleFragment extends BaseFragment {

    /**
     * 学习圈
     */
    @BindView(R.id.prv_status)
    PullToRefreshRecyclerView prvStatus;
    /**
     * 学习圈列表
     */
     private RecyclerView recyclerView;
    /**
     * 适配器
     */
    private StudyCircleAdapter adapter;
    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
     setTitle("学习圈");
     setSubTitle("发圈");
        prvStatus.setMode(PullToRefreshBase.Mode.BOTH);
        recyclerView = prvStatus.getRefreshableView();
        adapter = new StudyCircleAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_strudy_circle;
    }

}
