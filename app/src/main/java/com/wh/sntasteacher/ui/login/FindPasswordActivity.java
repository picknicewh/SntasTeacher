package com.wh.sntasteacher.ui.login;

import android.content.Intent;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;

import butterknife.OnClick;

public class FindPasswordActivity extends BaseActivity {


    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setLeftImage(R.mipmap.ic_back);
        setTitle("找回密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_find_password;
    }

    @OnClick(R.id.tv_next)
    public void next() {
        Intent intent = new Intent(this,ModifyPasswordActivity.class);
        startActivity(intent);
    }
}
