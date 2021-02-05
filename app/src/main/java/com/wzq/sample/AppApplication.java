package com.wzq.sample;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wzq.mvvmsmart.base.BaseApplicationMVVM;
import com.wzq.mvvmsmart.crash.CaocConfig;
import com.wzq.mvvmsmart.utils.KLog;
import com.wzq.sample.ui.DemoActivity;


/**
 * @author huanghuanfei
 */
public class AppApplication extends BaseApplicationMVVM {
    @Override
    public void onCreate() {
        super.onCreate();
        //是否开启打印日志
        KLog.init(BuildConfig.DEBUG);
        //初始化全局异常崩溃
        initCrash();
        LiveEventBus.config()
                // 配置支持跨进程、跨APP通信，传入Context，需要在application onCreate中配置
                .supportBroadcast(this)
                //    整个生命周期（从onCreate到onDestroy）都可以实时收到消息
                .lifecycleObserverAlwaysActive(true);
    }

    private void initCrash() {
        CaocConfig.Builder.create()
                //背景模式,开启沉浸式
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT)
                //是否启动全局异常捕获
                .enabled(true)
                //是否显示错误详细信息
                .showErrorDetails(true)
                //是否显示重启按钮
                .showRestartButton(true)
                //是否跟踪Activity
                .trackActivities(true)
                //崩溃的间隔时间(毫秒)
                .minTimeBetweenCrashesMs(2000)
                //错误图标
                .errorDrawable(R.mipmap.ic_launcher)
                //重新启动后的activity
                .restartActivity(DemoActivity.class)
//                .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
//                .eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }

    static {
        ClassicsFooter.REFRESH_FOOTER_LOADING = "加载中...";
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context));
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context).setDrawableSize(20));
    }
}
