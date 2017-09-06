package com.dgcredit.baselib;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;

// 实现PathReplaceService接口，并加上一个Path内容任意的注解即可
@Route(path = "/component/PathReplaceServiceImpl") // 必须标明注解
public class PathReplaceServiceImpl implements PathReplaceService {
    /**
     * For normal path.
     *
     * @param path raw path
     */
    public String forString(String path) {
        return path;    // 按照一定的规则处理之后返回处理后的结果
    }

    /**
     * For uri type.
     *
     * @param uri raw uri
     */
    public Uri forUri(Uri uri) {
        return uri;    // 按照一定的规则处理之后返回处理后的结果
    }

    @Override
    public void init(Context context) {
        Log.i("TAG","初始化ARouter---》PathReplaceServiceImpl");
    }
}