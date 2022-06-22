package com.cas.domain;

import java.util.Map;

/**
 * @author xiang_long
 * @version 1.0
 * @date 2022/6/20 2:28 下午
 * @desc
 */
public class ResponseResult {

    private String code;
    private String msg;
    private Map<String, String>  data;

    public ResponseResult(String msg, String code, Map<String, String> data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
