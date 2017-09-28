package com.wh.sntasteacher.ui.login;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;

public class ModifyPasswordActivity extends BaseActivity {


    @Override
    public void setTop() {

    }

    @Override
    public void initData() {
       setLeftImage(R.mipmap.ic_back);
        setTitle("设置密码");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_modify_passowrd;
    }
}
