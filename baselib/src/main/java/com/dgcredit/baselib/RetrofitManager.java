package com.dgcredit.baselib;

import com.dgcredit.httplib.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DAGONG on 2017/3/15.
 */

public class RetrofitManager {
    private volatile static RetrofitManager singleton;
    private Retrofit retrofit;
    private CacheProvider cacheProvider;

    private RetrofitManager() {
        initRetrofit();
//        initRxCache();
    }

    public static RetrofitManager getSingleton() {
        if (singleton == null) {
            synchronized (RetrofitManager.class) {
                if (singleton == null) {
                    singleton = new RetrofitManager();
                }
            }
        }
        return singleton;
    }

    private void initRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_HOST)
                    .client(getDefaultOkHttp())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }
    }

  /*  private CacheProvider initRxCache() {
        File externalCacheDir = BaseApplication.getInstance().getExternalFilesDir(AppConfig.RESPONSE_CACHE);
        if (externalCacheDir != null) {
            cacheProvider = new RxCache.Builder()
                    .persistence(externalCacheDir, new GsonSpeaker())
                    .using(CacheProvider.class);
        }else {
            cacheProvider = new RxCache.Builder()
                    .persistence(BaseApplication.getInstance().getFilesDir(), new GsonSpeaker())
                    .using(CacheProvider.class);
        }
        return cacheProvider;
    }*/


    private Gson getGson() {
        return new GsonBuilder()
                .serializeNulls()
                .enableComplexMapKeySerialization()
                .create();
    }

    /**
     * 开启缓存
     *
     * @return
     */

    private OkHttpClient getDefaultOkHttp() {
        return new OkHttpClient.Builder()
                //开启缓存
                .cookieJar(new CookieManger(BaseApplication.getInstance()))
                .cache(getResponseCache())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                //添加缓存拦截
                .addNetworkInterceptor(new CacheInterceptor())
                .addInterceptor(new CacheInterceptor())
                .build();
    }

    /**
     * Android/data/包名/cache/response
     *
     * @return
     */
    public Cache getResponseCache() {
        File externalCacheDir = BaseApplication.getInstance().getExternalFilesDir(AppConfig.RESPONSE_CACHE);
        if (externalCacheDir != null) {
            return new Cache(externalCacheDir, AppConfig.DEFAULT_RESPONSE_CACHE_SIZE);
        }else {
            return new Cache(BaseApplication.getInstance().getFilesDir(), AppConfig.DEFAULT_RESPONSE_CACHE_SIZE);
        }
    }

    public <T> T  getApiService(Class<T> service) {
        return retrofit.create(service);
    }
}
