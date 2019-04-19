package com.wjs.result;

public enum ResultEnum {
    // 成功
    SUCCESS(200,"成功"),

//    无数据
    NODATA(201,"查询无数据"),
    // 失败
    FAIL(400,"失败"),

    // 未认证（签名错误）
    UNAUTHORIZED(401,"未授权"),

    // 接口不存在
    NOT_FOUND(404,"接口不存在"),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500,"服务器内部错误");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
