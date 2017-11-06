package com.dgcredit.wechatcomponent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


/**
 * 需要实现wxapi/WXEntryActivity
 */
public class WeChatActivity extends AppCompatActivity {

    private IWXAPI wxapi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wechatcomponent_activity_we_chat);
        wxapi = WXAPIFactory.createWXAPI(this, "wxcc16fee42201d363");


    }

    public void share(View view) {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setCanceledOnTouchOutside(true);
        View inflate = LayoutInflater.from(this).inflate(R.layout.wechatcomponent_layout_share_bg, null);
        dialog.setContentView(inflate);
        dialog.show();
        inflate.findViewById(R.id.tv1).setOnClickListener(v->{
            initShared(SendMessageToWX.Req.WXSceneSession,"https://www.baidu.com/","标题","简介",BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
            dialog.dismiss();
        });
        inflate.findViewById(R.id.tv2).setOnClickListener(v->{
            initShared(SendMessageToWX.Req.WXSceneTimeline,"https://www.baidu.com/","标题","简介",BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
            dialog.dismiss();
        });
        inflate.findViewById(R.id.tv3).setOnClickListener(v->{
            initShared(SendMessageToWX.Req.WXSceneFavorite,"https://www.baidu.com/","标题","简介",BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
            dialog.dismiss();
        });
    }

    /**
     * @param wxScene 分享微信渠道
     * @param url 分享链接
     * @param title 分享标题
     * @param description 分享简介
     * @param thumbBitmap 分享的图片
     */
    private void initShared(int wxScene, String url, String title, String description, Bitmap thumbBitmap) {
        WXWebpageObject wxWebpageObject = new WXWebpageObject();
        wxWebpageObject.webpageUrl=url;
        WXMediaMessage mediaMessage = new WXMediaMessage(wxWebpageObject);
        mediaMessage.title = title;
        mediaMessage.description = description;
        mediaMessage.thumbData = Util.bmpToByteArray(thumbBitmap,true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = mediaMessage;
        req.scene = wxScene;
    }
}
