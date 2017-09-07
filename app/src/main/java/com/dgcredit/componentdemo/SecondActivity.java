package com.dgcredit.componentdemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.componentdemo.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    private ActivitySecondBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_second);
        initView();

    }

    private void initView() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add((Fragment) ARouter.getInstance().build("/modulea/fragment").navigation());
        fragments.add((Fragment) ARouter.getInstance().build("/moduleb/fragment").navigation());
        List<String> titles = new ArrayList<>();
        titles.add("ModuleA");
        titles.add("ModuleB");
        mBinding.vp.setAdapter(new MyAdapter(getSupportFragmentManager(),fragments,titles));
        mBinding.tabLayout.setupWithViewPager(mBinding.vp);
    }
    private class  MyAdapter  extends FragmentStatePagerAdapter{
        private  List<Fragment> fragments;
        private List<String> titles;
        MyAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
