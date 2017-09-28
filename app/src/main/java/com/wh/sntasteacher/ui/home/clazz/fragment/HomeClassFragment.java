package com.wh.sntasteacher.ui.home.clazz.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseFragment;
import com.wh.sntasteacher.ui.home.clazz.activity.CourseListActivity;
import com.wh.sntasteacher.ui.home.clazz.activity.FunnyVideoDetailActivity;
import com.wh.sntasteacher.ui.home.clazz.activity.FunnyVideoListActivity;
import com.wh.sntasteacher.ui.home.clazz.activity.TeacherListActivity;
import com.wh.sntasteacher.ui.home.clazz.adapter.BannerLoopAdapter;
import com.wh.sntasteacher.ui.home.clazz.adapter.FunnyVideoAdapter;
import com.wh.sntasteacher.ui.home.clazz.adapter.GoodTeacherAdapter;
import com.wh.sntasteacher.ui.home.clazz.adapter.OpenClassAdapter;
import com.wh.sntasteacher.util.G;
import com.wh.sntasteacher.util.OnItemClickListener;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeClassFragment extends BaseFragment implements OnItemClickListener {
    /**
     * 轮播图
     */
    @BindView(R.id.rollPagerView)
    RollPagerView mRollPagerView;
    /**
     * 更多老师
     */
    @BindView(R.id.tv_more_teacher)
    TextView tvMoreTeacher;
    /**
     * 老师列表
     */
    @BindView(R.id.rv_teacher)
    RecyclerView rvTeacher;
    private GoodTeacherAdapter teacherAdapter;
    /**
     * 趣味课堂
     */
    @BindView(R.id.tv_more_video)
    TextView tvMoreVideo;
    /**
     * 趣味课堂列表
     */
    @BindView(R.id.rv_video)
    RecyclerView rvVideo;
    private FunnyVideoAdapter videoAdapter;
    /**
     * 更多公开课
     */
    @BindView(R.id.tv_more_class)
    TextView tvMoreConsult;
    /**
     * 公开课列表
     */
    @BindView(R.id.rv_open_class)
    RecyclerView rvOpenClass;
    private OpenClassAdapter classAdapter;

    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setTitle("课堂中心");
        setRightImage(R.mipmap.ic_search);
        G.initDisplaySize(getActivity());
        mRollPagerView.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));
        mRollPagerView.setAdapter(new BannerLoopAdapter(mRollPagerView));
        teacherAdapter = new GoodTeacherAdapter(getActivity());
        rvTeacher.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvTeacher.setNestedScrollingEnabled(false);
        rvTeacher.setAdapter(teacherAdapter);
        videoAdapter = new FunnyVideoAdapter(getActivity());
        videoAdapter.setOnItemClickListener(funnyVideoListener);
        rvVideo.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvVideo.setNestedScrollingEnabled(false);
        rvVideo.setAdapter(videoAdapter);
        classAdapter = new OpenClassAdapter();
        rvOpenClass.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvOpenClass.setNestedScrollingEnabled(false);
        rvOpenClass.setAdapter(classAdapter);
        classAdapter.setOnItemClickListener(this);
    }

    @Override
    public void setRightOnClickListener() {
        super.setRightOnClickListener();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_class;
    }

    private OnItemClickListener funnyVideoListener = new OnItemClickListener() {
        @Override
        public void onClick(View view, int position) {
           Intent intent = new Intent(getActivity(), FunnyVideoDetailActivity.class);
            startActivity(intent);
        }
    };
    @Override
    public void onClick(View view, int position) {

    }

    @OnClick(R.id.tv_more_video)
    public void moreVideo() {
        Intent intent = new Intent(getActivity(),FunnyVideoListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_more_class)
    public void moreCourse() {
        Intent intent = new Intent(getActivity(),CourseListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.tv_more_teacher)
    public void moreTeacher() {
        Intent intent = new Intent(getActivity(),TeacherListActivity.class);
        startActivity(intent);
    }
}
