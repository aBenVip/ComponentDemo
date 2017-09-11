package com.dgcredit.sharecomponent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dgcredit.baselib.ShareService;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/11
 * 备注:
 */

@Route(path = "/share/service")
public class ShareServiceImpl implements ShareService {
    private Context context;
    @Override
    public void share(Activity activity) {
        this.context = activity;
        UMWeb web = new UMWeb("https://www.baidu.com/");
        web.setTitle("This is music title");//标题
        web.setThumb(new UMImage(activity,R.drawable.umeng_socialize_sina));  //缩略图
        web.setDescription("my description");//描述\
        new ShareAction(activity)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                .withMedia(web)//分享内容
                .setCallback(shareListener)//回调监听器
                .open();
    }

    @Override
    public void onActivityResult(Activity activity,int requestCode, int resultCode, Intent data) {
        UMShareAPI.get(activity).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void init(Context context) {
        Log.i("TAG","ShareService初始化了+++++++++++++++");
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
            Log.i("TAG","start+++++++++++++++");
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {

            Log.i("TAG","++++++++++++++++++++++chenggong");
            Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();

        }
    };
}
