package com.dgcredit.modulea;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.baselib.RetrofitManager;

@Route(path = "/modulea/a")
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulea_activity_main2);
        getSupportFragmentManager().beginTransaction().add(R.id.ft_content, (Fragment)ARouter.getInstance().build("/modulea/fragment").navigation()).commit();
    }
}
