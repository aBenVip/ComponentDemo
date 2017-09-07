package com.dgcredit.moduleb;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/moduleb/b")
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleb_activity_second);
        getSupportFragmentManager().beginTransaction().add(R.id.ft_content, (Fragment) ARouter.getInstance().build("/moduleb/fragment").navigation()).commit();
    }
}
