package com.chen.lvyou.vo;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/23 10:26
 */
public class JsonObject {
    private boolean success;
    private String msg = "success";
    private Object data;
    private String code = "200";

    public JsonObject() {
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Object getData() {
        return this.data;
    }

    public String getCode() {
        return this.code;
    }

    public JsonObject success(){
        this.success = true;
        return this;
    }

    public JsonObject suceess(String msg){
        this.msg = msg;
        return this.success();
    }

    public JsonObject fail(){
        this.success = false;
        return this;
    }

    public JsonObject fail(String msg){
        this.msg = msg;
        return this.fail();
    }

    public JsonObject sendMsg(String msg){
        this.msg = msg;
        return this;
    }

    public JsonObject sendData(Object data){
        this.data = data;
        return this;
    }

    public JsonObject setCode(String code){
        this.code = code;
        return this;
    }
}
