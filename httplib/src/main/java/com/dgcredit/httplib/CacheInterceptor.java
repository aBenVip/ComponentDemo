package com.dgcredit.httplib;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class CacheInterceptor implements Interceptor {
    private int maxCacheTime = 60;

    public CacheInterceptor() {
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();

//        if (!NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {//如果网络不可用或者设置只用网络
//            request = request.newBuilder()
//                    .cacheControl(CacheControl.FORCE_CACHE)
//                    .build();
//                    Log.d("OkHttp", "网络不可用请求拦截");
//
//        } else if (NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {//网络可用
//            request = request.newBuilder()
//                    .cacheControl(CacheControl.FORCE_NETWORK)
//                    .build();
//                   Log.d("OkHttp", "网络可用请求拦截");
//        }
        Response response = chain.proceed(request);
//        if (NetWorkUtil.isNetworkConnected(BaseApplication.getInstance())) {//如果网络可用
//                    Log.d("OkHttp", "网络可用响应拦截");
//            response = response.newBuilder()
//                    //覆盖服务器响应头的Cache-Control,用我们自己的,因为服务器响应回来的可能不支持缓存
//                    .header("Cache-Control", "public,max-age=" + maxCacheTime)
//                    .removeHeader("Pragma")
//                    .build();
//        } else {
//            Log.d("OkHttp", "网络不可用响应拦截");
//            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
//            response = response.newBuilder()
//                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                    .removeHeader("Pragma")
//                    .build();
//        }
        return response;

    }
}