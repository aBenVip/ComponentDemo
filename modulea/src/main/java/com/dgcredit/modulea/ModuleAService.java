package com.dgcredit.modulea;

import com.dgcredit.httplib.ApiService;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

/**
 * 类描述:
 * 创建人:aBen
 * 创建时间:2017/9/7
 * 备注:
 */

public interface ModuleAService extends ApiService {
    @GET("aa")
    Observable<ResponseBody> aa();
}
