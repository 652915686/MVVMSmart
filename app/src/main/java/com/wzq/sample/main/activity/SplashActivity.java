package com.wzq.sample.main.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.wzq.mvvmsmart.utils.SPUtils;
import com.wzq.mvvmsmart.utils.StatusBarUtil;
import com.wzq.sample.BR;
import com.wzq.sample.R;
import com.wzq.sample.base.BaseActivity;
import com.wzq.sample.base.BaseViewModel;
import com.wzq.sample.databinding.ActivitySplashBinding;
import com.wzq.sample.main.fragment.SplashFragment;
import com.wzq.sample.ui.vp_frg.BaseFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanghuanfei
 */
public class SplashActivity extends BaseActivity<ActivitySplashBinding, BaseViewModel> implements ViewPager.OnPageChangeListener {
    private final String START_APP = "start_app";
    private int[] ints;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        setTheme(R.style.AppTheme_Launcher);
        //设置状态栏透明
        StatusBarUtil.setTransparentForWindow(this);
        binding.setPresenter(new Presenter());
        if (SPUtils.getInstance().getBoolean(START_APP, true)) {
            List<Fragment> list = new ArrayList<>();
            ints = new int[]{R.mipmap.splash_guide_one, R.mipmap.splash_guide_two, R.mipmap.splash_guide_three};
            for (int i : ints) {
                list.add(new SplashFragment(i));
            }
            binding.viewPager.setAdapter(new BaseFragmentPagerAdapter(getSupportFragmentManager(), list));
            binding.viewPager.addOnPageChangeListener(this);
        } else {
            handler = new Handler();
            handler.postDelayed(() -> SplashActivity.this.startActivityAndFinish(MainActivity.class), 1000);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == (ints.length - 1)) {
            binding.tvStart.setVisibility(View.VISIBLE);
        } else {
            binding.tvStart.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class Presenter extends SplashActivity {
        public void startClick() {
            if (SPUtils.getInstance().getBoolean(START_APP, true)) {
                SPUtils.getInstance().put(START_APP, false);
                SplashActivity.this.startActivityAndFinish(MainActivity.class);
            }
        }
    }
}
