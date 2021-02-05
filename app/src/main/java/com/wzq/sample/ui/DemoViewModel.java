package com.wzq.sample.ui;

import android.app.Application;

import androidx.annotation.NonNull;

import com.wzq.mvvmsmart.event.SingleLiveEvent;
import com.wzq.sample.base.BaseViewModel;


public class DemoViewModel extends BaseViewModel {
    //使用Observable
    public SingleLiveEvent<Boolean> requestCameraPermissions = new SingleLiveEvent<>();
    //使用LiveData
    public SingleLiveEvent<String> loadUrlEvent = new SingleLiveEvent<>();

    public DemoViewModel(@NonNull Application application) {
        super(application);
    }


}
