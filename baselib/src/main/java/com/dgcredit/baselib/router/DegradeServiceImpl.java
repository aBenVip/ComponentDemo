package com.dgcredit.baselib.router;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

@Route(path = "/component/DegradeServiceImpl")
public class DegradeServiceImpl implements DegradeService {
  @Override
  public void onLost(Context context, Postcard postcard) {
      // do something.
  }

  @Override
  public void init(Context context) {
    Log.i("TAG","初始化ARouter---》DegradeServiceImpl");
  }
}