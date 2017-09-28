package com.wh.sntasteacher.ui.home.user;


import android.content.Intent;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseFragment;
import com.wh.sntasteacher.ui.login.LoginActivity;
import com.wh.sntasteacher.widget.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class UserCenterFragment extends BaseFragment {

    /**
     * 头像
     */
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    /**
     * 用户名/登陆或者注册
     */
    @BindView(R.id.tv_login)
    TextView tvLogin;
    /**
     * 绑定手机号
     */
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    /**
     * 已购课程
     */
    @BindView(R.id.tv_cause)
    TextView tvCause;
    /**
     * 收藏
     */
    @BindView(R.id.tv_collect)
    TextView tvCollect;
    /**
     * 我的下载
     */
    @BindView(R.id.tv_download)
    TextView tvDownload;
    /**
     * 我的预约
     */
    @BindView(R.id.tv_book)
    TextView tvBook;
    /**
     * 意见反馈
     */
    @BindView(R.id.tv_advice)
    TextView tvAdvice;
    /**
     * 清除缓存
     */
    @BindView(R.id.tv_clean)
    TextView tvClean;
    /**
     * 关于
     */
    @BindView(R.id.tv_about)
    TextView tvAbout;



    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_center;
    }

    @OnClick(R.id.tv_login)
    public void login() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}
