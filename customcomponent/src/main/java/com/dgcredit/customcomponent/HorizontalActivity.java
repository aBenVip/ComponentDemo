package com.dgcredit.customcomponent;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;

public class HorizontalActivity extends AppCompatActivity {

    private RecyclerView mLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customcomponent_activity_horizontal);
        mLv = (RecyclerView) findViewById(R.id.horizontal_lv);
        mLv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        PagerSnapHelper helper = new PagerSnapHelper();
        HorizontalAdapter adapter = new HorizontalAdapter();
        mLv.setAdapter(adapter);
        helper.attachToRecyclerView(mLv);
    }
}
