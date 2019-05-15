package com.chen.lvyou.vo;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/23 9:20
 */
public enum RespBasicCode {
    SUCCESS("200", "成功"),
    PARAMETER_ERROR("400", "参数异常"),
    NOT_PERMISSION("403", "没有权限"),
    ERROR("500", "异常错误"),
    BUSSINESS_EXCETION("416", "业务异常"),
    METHOD_NOT_ALLOWED("415", "方法不允许"),
    BAD_REQUEST("400", "无效的请求"),
    NOT_FOUND("404", "资源不存在"),
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型");

    private String resultCode;
    private String resultDes;

    private RespBasicCode(String resultCode, String resultDes) {
        this.resultCode = resultCode;
        this.resultDes = resultDes;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultDes() {
        return this.resultDes;
    }

    public static RespBasicCode getByCode(String code) {
        if (code != null && !"".equals(code)) {
            RespBasicCode[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                RespBasicCode respBasicCode = var1[var3];
                if (respBasicCode.getResultCode().equals(code)) {
                    return respBasicCode;
                }
            }

            return SUCCESS;
        } else {
            return null;
        }
    }
}
