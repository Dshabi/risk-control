package com.zhenghao.risk.control.contract.response;

import com.zhenghao.risk.control.contract.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 785132455L;

    protected boolean success;

    protected Integer returnCode;

    protected String returnMsg;

    protected T result;

    public static <T> BaseResponse<T> newSuccessResponse(T result) {
        return new BaseResponseBuilder<T>().success(true).result(result)
                .returnCode(ErrorCode.SUCCESS.getCode())
                .returnMsg(ErrorCode.SUCCESS.getDefaultMsg()).build();
    }

    public static <T> BaseResponse<T> newFailureResponse(T result) {
        return new BaseResponseBuilder<T>().success(false).result(result)
                .returnCode(ErrorCode.FAILURE.getCode())
                .returnMsg(ErrorCode.FAILURE.getDefaultMsg()).build();
    }

}
