package com.wh.sntasteacher.ui.login;

import android.content.Intent;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;

import butterknife.OnClick;

public class SimpleLoginActivity extends BaseActivity {


    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setTitle("登录");
        setSubTitle("注册");
        setLeftImage(R.mipmap.ic_back);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_simple_login;
    }

    @OnClick(R.id.tv_login)
    public void login() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
