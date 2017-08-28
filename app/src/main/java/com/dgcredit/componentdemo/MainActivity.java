package com.dgcredit.componentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moduleA(View view) {
        ARouter.getInstance().build("/modulea/a").navigation();
    }
    public void moduleB(View view) {
        ARouter.getInstance().build("/moduleb/b").navigation();
    }


}
