package com.dgcredit.componentdemo;

import android.app.Application;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.baselib.BaseApplication;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/8/28
 * 备注:
 */

public class MyApplication extends BaseApplication {

    static {
        PlatformConfig.setWeixin("wxcc16fee42201d363", "e0d86ed317d1496e0008a4a89a6139a9");
        PlatformConfig.setQQZone("1106330463", "Xgbg5GBBqwjfNdYv");
        PlatformConfig.setSinaWeibo("3524847437", "d7a3502d401e2646bf10bebacf8d9125", "http://sns.whalecloud.com");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        UMShareAPI.get(this);
    }
}
