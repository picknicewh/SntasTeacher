package com.wh.sntasteacher.ui.home;

import android.support.annotation.IdRes;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseActivity;
import com.wh.sntasteacher.base.BaseFragment;
import com.wh.sntasteacher.common.Consist;
import com.wh.sntasteacher.common.ViewPagerAdapter;
import com.wh.sntasteacher.ui.home.circle.StudyCircleFragment;
import com.wh.sntasteacher.ui.home.clazz.fragment.HomeClassFragment;
import com.wh.sntasteacher.ui.home.message.GroupMessageFragment;
import com.wh.sntasteacher.ui.home.user.UserCenterFragment;
import com.wh.sntasteacher.util.G;
import com.wh.sntasteacher.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

import static io.rong.imkit.utils.SystemUtils.getCurProcessName;


public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    /**
     * 页面
     */
    @BindView(R.id.vp_main)
    NoScrollViewPager vpMain;
    /**
     * 课堂
     */
    @BindView(R.id.rb_class_home)
    RadioButton rbClassHome;
    /**
     * 学习圈
     */
    @BindView(R.id.rb_study_circle)
    RadioButton rbStudyCircle;
    /**
     * 交流群
     */
    @BindView(R.id.rb_group_info)
    RadioButton rbGroupInfo;
    /**
     * 我的
     */
    @BindView(R.id.rb_user_center)
    RadioButton rbUserCenter;
    @BindView(R.id.rg_nav)
    RadioGroup rgNav;
    /**
     * 数据列表
     */
    private List<BaseFragment> fragmentList;
    /**
     * 适配器
     */
    private ViewPagerAdapter adapter;

    @Override
    public void setTop() {
        isHideNavigation(true);
    }

    @Override
    public void initData() {
        connect("YbknT5+Sp1/dc4RdRCc6/9NnhDjbRWKHfjS54nZE+38HEGlnvANFtyG1XQWty6YrlR/e2mM0PH4/25/aCDY51Q==");
         initFragment();
        vpMain.setNoScroll(true);

        rgNav.setOnCheckedChangeListener(this);
    }
    private void initFragment(){
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeClassFragment());
        fragmentList.add(new StudyCircleFragment());
        fragmentList.add(new GroupMessageFragment());
        fragmentList.add(new UserCenterFragment());
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        vpMain.setAdapter(adapter);
        vpMain.setCurrentItem(0);

    }
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_class_home:
                vpMain.setCurrentItem(Consist.HOME);
                break;
            case R.id.rb_study_circle:
                vpMain.setCurrentItem(Consist.STUDY);
                break;
            case R.id.rb_group_info:
                vpMain.setCurrentItem(Consist.INFROMATION);
                break;
            case R.id.rb_user_center:
                vpMain.setCurrentItem(Consist.ABOUT);
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }


    public void connect(String token) {

        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {

            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {
                    G.log("LoginActivity"+ "--onTokenIncorrect" );
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                    G.log("LoginActivity"+ "--onSuccess" + userid);
                    //     startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    //    finish();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {
                    G.log("LoginActivity"+ "--onError" );
                }
            });
        }
    }

}
