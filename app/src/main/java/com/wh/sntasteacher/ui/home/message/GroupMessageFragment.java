package com.wh.sntasteacher.ui.home.message;


import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wh.sntasteacher.R;
import com.wh.sntasteacher.base.BaseFragment;

import butterknife.BindView;
import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;

public class GroupMessageFragment extends BaseFragment {

    /**
     * 推荐团列表
     */
    @BindView(R.id.rv_groups)
    RecyclerView rvGroups;
    /**
     * 删除推荐团
     */
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    /**
     * 推荐团列表
     */
    private RecommendGroupAdapter adapter;
    @Override
    public void setTop() {
        isHideNavigation(false);
    }

    @Override
    public void initData() {
        setTitle("团消息");
        setRightImage(R.mipmap.ic_add);
        setSubRightImage(R.mipmap.ic_search);
        adapter = new RecommendGroupAdapter();
        rvGroups.setLayoutManager(new GridLayoutManager(getContext(),4));
        rvGroups.setAdapter(adapter);
        initframent();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_group_message;
    }
    /**
     *获取聊天列表
     */
    public void  initframent(){
        try {
            ConversationListFragment fragment = new ConversationListFragment();
            Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false") //设置私聊会话非聚合显示
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")//设置群组会话聚合显示
                    .build();
            fragment.setUri(uri);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.rong_content, fragment);
            transaction.commitAllowingStateLoss();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
