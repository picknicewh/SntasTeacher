package com.wh.sntasteacher.ui.home.message;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;

/**
 * 作者： wh
 * 时间：  2017/9/26
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class ConversationActivity  extends BaseActivity {


    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
     setLeftImage(R.mipmap.ic_back);
     setTitle("689");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_conversation;
    }

}
