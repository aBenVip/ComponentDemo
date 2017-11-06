package com.dgcredit.sharecomponent;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dgcredit.baselib.ShareService;
import com.dgcredit.baselib.service.ShareApplicationService;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.UmengErrorCode;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/13
 * 备注:
 */
@Route(path = "/share/application/service")
public class ShareApplicationServiceImpl implements ShareApplicationService {
    @Override
    public void initShare(Application application) {
        PlatformConfig.setWeixin("wxcc16fee42201d363", "e0d86ed317d1496e0008a4a89a6139a9");
        PlatformConfig.setQQZone("1106330463", "Xgbg5GBBqwjfNdYv");
        PlatformConfig.setSinaWeibo("3524847437", "d7a3502d401e2646bf10bebacf8d9125", "http://sns.whalecloud.com");
        Config.DEBUG = true;
        UMShareAPI.get(application);
    }

    @Override
    public void init(Context context) {

    }
}
