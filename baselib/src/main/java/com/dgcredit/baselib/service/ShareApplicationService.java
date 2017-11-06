package com.dgcredit.baselib.service;

import android.app.Application;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/13
 * 备注:
 */

public interface ShareApplicationService extends IProvider {
    void initShare(Application application);
}
