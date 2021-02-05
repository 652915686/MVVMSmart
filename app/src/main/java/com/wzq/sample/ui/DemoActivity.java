package com.wzq.sample.ui;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.wzq.sample.BR;
import com.wzq.sample.R;
import com.wzq.sample.databinding.ActivityDemoBinding;
import com.wzq.sample.base.BaseActivity;
import com.wzq.sample.base.BaseViewModel;

public class DemoActivity extends BaseActivity<ActivityDemoBinding, BaseViewModel> {
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    public void initParam() {
        super.initParam();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_demo;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }


}
