package com.zhenghao.risk.control.contract.enums;

public enum ErrorCode {

    SUCCESS(200, "SUCCESS"),
    FAILURE(400, "FAILURE");

    private Integer code;

    private String defaultMsg;

    ErrorCode(Integer code, String defaultMsg) {
        this.code = code;
        this.defaultMsg = defaultMsg;
    }

    public Integer getCode() {
        return code;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }
}
