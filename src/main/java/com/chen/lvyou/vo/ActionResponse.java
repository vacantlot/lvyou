package com.chen.lvyou.vo;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/23 9:24
 */
public class ActionResponse<T> {
    private ActionResponse<T>.Head head = new ActionResponse.Head();
    private ActionResponse<T>.Body body = new ActionResponse.Body();

    public ActionResponse() {
    }

    public static <T> ActionResponse<T> success() {
        return new ActionResponse(RespBasicCode.SUCCESS);
    }

    public static <T> ActionResponse<T> fail(RespBasicCode respCode) {
        return new ActionResponse(respCode);
    }

    public static <T> ActionResponse<T> fail(RespBasicCode respCode, T result) {
        return new ActionResponse(respCode, result);
    }

    public static <T> ActionResponse<T> success(T result) {
        return new ActionResponse(RespBasicCode.SUCCESS, result);
    }

    public ActionResponse(RespBasicCode respCode) {
        this.head.setCode(respCode.getResultCode());
        this.head.setResult(respCode.getResultDes());
    }

    public ActionResponse(RespBasicCode respCode, T result) {
        this.head.setCode(respCode.getResultCode());
        this.head.setResult(respCode.getResultDes());
        this.body.setResult(result);
    }

    public ActionResponse(RespBasicCode respBasicCode, String msg, T result) {
        this.head.result = msg;
        this.head.code = respBasicCode.getResultCode();
        this.body.data = result;
    }

    public ActionResponse(String code, String msg, T result) {
        this.head.code = code;
        this.head.result = msg;
        this.body.data = result;
    }

    public ActionResponse<T>.Head getHead() {
        return this.head;
    }

    public void setBody(T result) {
        this.body.data = result;
    }

    public T getBody() {
        return this.body.getResult();
    }

    public class Head {
        private String code;
        private String result;

        public Head() {
        }

        public String getResult() {
            return this.result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

    private class Body {
        private T data;

        public Body() {
        }

        public T getResult() {
            return this.data;
        }

        public void setResult(T result) {
            this.data = result;
        }
    }
}
