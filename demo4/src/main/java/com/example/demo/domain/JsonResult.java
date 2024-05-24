package com.example.demo.domain;
public class JsonResult<T> {
    //数据
    private T result;
    //状态码
    private String code;
    //信息
    private String msg;
    /**
     * 若没有数据返回，默认状态码为200，提示信息为：操作成功！
     */
    public JsonResult() {
        this.code = "200";
        this.msg = "操作成功！";
    }
    /**
     * 若没有数据返回，可以⼈为指定状态码和提示信息
     * @param code
     * @param msg
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    /**
     * 有数据返回时，状态码为200，默认提示信息为：操作成功！
     * @param data
     */
    public JsonResult(T data) {
        this.result = data;
        this.code = "200";
        this.msg = "操作成功！";
    }
    /**
     * 有数据返回，状态码为200，⼈为指定提示信息
     * @param data
     * @param msg
     */
    public JsonResult(T data, String msg) {
        this.result = data;
        this.code = "200";
        this.msg = msg;
    }
    public T getData() {
        return result;
    }
    public void setData(T data) {
        this.result = data;
    }
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
}
