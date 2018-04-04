package com.zhenghao.risk.control.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * zhenghao
 * 2018/4/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FireResult {

    private Boolean isProcessed = false;

    private String returnCode;
}
