package com.wh.sntasteacher.ui.home.clazz.activity;

import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;
import com.wh.sntasteacher.base.BaseFragment;
import com.wh.sntasteacher.common.ViewPagerAdapter;
import com.wh.sntasteacher.ui.home.clazz.fragment.AllCourseFragment;
import com.wh.sntasteacher.ui.home.clazz.fragment.RecommendVideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CourseListActivity extends BaseActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_video)
    RadioButton rbVideo;
    @BindView(R.id.line_all)
    View lineAll;
    @BindView(R.id.line_video)
    View lineVideo;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.rg_course)
    RadioGroup rgCourse;
    private List<BaseFragment> fragmentList;
    private ViewPagerAdapter adapter;

    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setTitle("课程列表");
        setLeftImage(R.mipmap.ic_back);
        setRightImage(R.mipmap.ic_search);
        initFragment();
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        AllCourseFragment allCourseFragment = new AllCourseFragment();
        fragmentList.add(allCourseFragment);
        RecommendVideoFragment videoFragment = new RecommendVideoFragment();
        fragmentList.add(videoFragment);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentList);
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(2);
        mViewpager.setCurrentItem(0);
        mViewpager.addOnPageChangeListener(this);
        rgCourse.setOnCheckedChangeListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_course_list;
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            rbAll.setChecked(true);
            rbVideo.setChecked(false);
            lineAll.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
            lineVideo.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        } else if (position == 1) {
            rbAll.setChecked(false);
            rbVideo.setChecked(true);
            lineAll.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            lineVideo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }



    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId){
            case R.id.rb_all:
                mViewpager.setCurrentItem(0);
                lineAll.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
                lineVideo.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                break;
            case R.id.rb_video:
                mViewpager.setCurrentItem(1);
                lineAll.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
                lineVideo.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
                break;
        }
    }
}
