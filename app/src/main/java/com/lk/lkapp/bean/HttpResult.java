package com.lk.lkapp.bean;

import android.text.TextUtils;

/**
 * Package：com.lk.lkapp.bean
 * Created by user005 on 2016/12/17.
 * Description：.
 */

public class HttpResult<T> {

    private String code;
    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isOk() {
        return TextUtils.isEmpty(msg);
    }
}
