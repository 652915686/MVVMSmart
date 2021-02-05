package com.wzq.sample.ui.vp_frg;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * FragmentPager适配器
 * @author huanghuanfei
 */

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> title;

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public BaseFragmentPagerAdapter(FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (title != null) {
            return title.get(position);
        }
        return "";
    }
}
