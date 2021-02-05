package com.wzq.sample.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.wzq.sample.BR;
import com.wzq.sample.R;
import com.wzq.sample.base.BaseFragment;
import com.wzq.sample.base.BaseViewModel;
import com.wzq.sample.databinding.FragmentHomeBinding;

/**
 * @author huanghuanfei
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding, BaseViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_home;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
