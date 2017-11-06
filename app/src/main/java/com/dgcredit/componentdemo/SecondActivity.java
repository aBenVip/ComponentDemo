package com.dgcredit.componentdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dgcredit.baselib.BaseActivity;
import com.dgcredit.componentdemo.databinding.ActivitySecondBinding;

import java.util.ArrayList;
import java.util.List;


public class SecondActivity extends BaseActivity<MainPresenter,ActivitySecondBinding> implements MainContract.MainView{

    @Override
    public int getLayoutId() {
        return  R.layout.activity_second;
    }

    @Override
    public void initView() {
        mPresenter.setData();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add((Fragment) ARouter.getInstance().build("/modulea/fragment").navigation());
        fragments.add((Fragment) ARouter.getInstance().build("/moduleb/fragment").navigation());
        List<String> titles = new ArrayList<>();
        titles.add("ModuleA");
        titles.add("ModuleB");
        mViewBinding.vp.setAdapter(new MyAdapter(getSupportFragmentManager(),fragments,titles));
        mViewBinding.tabLayout.setupWithViewPager(mViewBinding.vp);
    }

    @Override
    public void getData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

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
