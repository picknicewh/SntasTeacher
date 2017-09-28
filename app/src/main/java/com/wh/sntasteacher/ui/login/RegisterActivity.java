package com.wh.sntasteacher.ui.login;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;

public class RegisterActivity extends BaseActivity {


    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
      setLeftImage(R.mipmap.ic_back);
      setTitle("注册");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }
}
