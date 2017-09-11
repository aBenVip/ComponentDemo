package com.dgcredit.baselib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/11
 * 备注:
 */

public interface ShareService extends IProvider {
    void share(Activity activity);
    void onActivityResult(Activity activity,int requestCode, int resultCode, Intent data);
}
