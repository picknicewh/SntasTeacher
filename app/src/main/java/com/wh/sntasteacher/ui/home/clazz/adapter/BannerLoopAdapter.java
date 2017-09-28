package com.wh.sntasteacher.ui.home.clazz.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.wh.sntasteacher.util.G;

/**
 * 作者： wh
 * 时间：  2017/9/25
 * 名称：
 * 版本说明：
 * 附加注释：
 * 主要接口：
 */
public class BannerLoopAdapter  extends LoopPagerAdapter {

    public BannerLoopAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(G.imgaes[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getRealCount() {
        return G.imgaes.length;
    }
}

