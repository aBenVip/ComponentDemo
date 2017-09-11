package com.dgcredit.componentdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.baselib.DataBindingActivity;
import com.dgcredit.baselib.ShareService;
import com.dgcredit.componentdemo.databinding.ActivityMainBinding;
import com.umeng.socialize.UmengTool;

public class MainActivity extends DataBindingActivity<ActivityMainBinding> {

    @Autowired(name = "/share/service")
    ShareService shareService;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mViewBinding.cehsi.setOnClickListener(v -> {
            Toast.makeText(this, "Lalallalalla ", Toast.LENGTH_SHORT).show();
        });
        mViewBinding.button2.setOnClickListener(v->{
            shareComponent();
        });
    }

    public void moduleA(View view) {
        ARouter.getInstance().build("/share/component").navigation();
    }

    public void moduleB(View view) {
        ARouter.getInstance().build("/moduleb/b").navigation();
    }

    public void shareComponent() {
//        ARouter.getInstance().build("/share/component").navigation();
        shareService.share(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        shareService.onActivityResult(this,requestCode, resultCode, data);
    }
}
