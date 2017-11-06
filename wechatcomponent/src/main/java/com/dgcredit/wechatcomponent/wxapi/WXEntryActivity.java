package com.dgcredit.wechatcomponent.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.dgcredit.wechatcomponent.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXEntryActivity extends Activity implements IWXAPIEventHandler{

    private IWXAPI mWxApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWxApi = WXAPIFactory.createWXAPI(this, "wxcc16fee42201d363", false);
        mWxApi.handleIntent(getIntent(), this);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        mWxApi.handleIntent(intent, this);
    }


    @Override
    public void onReq(BaseReq baseReq) {
        Log.i("TAG","++++++++++++++++++++++++++++++_________111");
        switch (baseReq.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:

                Toast.makeText(this, "COMMAND_GETMESSAGE_FROM_WX", Toast.LENGTH_SHORT).show();
                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:
                Toast.makeText(this, "COMMAND_SHOWMESSAGE_FROM_WX", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        this.finish();
    }

    @Override
    public void onResp(BaseResp baseResp) {
        Log.i("TAG","++++++++++++++++++++++++++++++_________1baseResp");
        String result = "";

        switch (baseResp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                result ="ERR_OK";
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                result ="ERR_USER_CANCEL";
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                result ="ERR_AUTH_DENIED";
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
                result ="ERR_UNSUPPORT";
                break;
            default:
                result ="ERR_OK";
                break;
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        this.finish();
    }
}
