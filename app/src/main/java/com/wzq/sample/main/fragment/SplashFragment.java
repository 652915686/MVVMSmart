package com.wzq.sample.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.wzq.sample.BR;
import com.wzq.sample.R;
import com.wzq.sample.base.BaseFragment;
import com.wzq.sample.base.BaseViewModel;
import com.wzq.sample.databinding.FragmentHomeBinding;
import com.wzq.sample.databinding.FragmentSplashBinding;

/**
 * @author huanghuanfei
 */
public class SplashFragment extends BaseFragment<FragmentSplashBinding, BaseViewModel> {
    private int id;

    public SplashFragment() {
    }

    public SplashFragment(int id) {
        this.id = id;
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_splash;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        binding.ivSplash.setImageResource(id);
    }
}
