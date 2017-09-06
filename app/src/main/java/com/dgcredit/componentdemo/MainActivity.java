package com.dgcredit.componentdemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.cehsi);
        textView.setOnClickListener(v -> {
            Toast.makeText(this, "Lalallalalla ", Toast.LENGTH_SHORT).show();
        });
    }

    public void moduleA(View view) {
        ARouter.getInstance().build("/modulea/a").navigation();
    }

    public void moduleB(View view) {
        ARouter.getInstance().build("/moduleb/b").navigation();
    }


    public void shareComponent(View view) {
        ARouter.getInstance().build("/share/component").navigation();
    }
}
