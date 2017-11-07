package com.dgcredit.componentdemo;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.baselib.BaseApplication;
import com.dgcredit.baselib.service.ShareApplicationService;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/8/28
 * 备注:
 */

public class MyApplication extends BaseApplication {

//    @Autowired(name = "/share/application/service")
//    ShareApplicationService shareApplicationService;

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.getInstance().inject(this);
//        shareApplicationService.initShare(this);
//        Config.DEBUG = true;
//        UMShareAPI.get(this);
    }
}
