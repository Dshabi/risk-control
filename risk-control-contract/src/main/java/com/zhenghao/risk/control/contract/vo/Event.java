package com.zhenghao.risk.control.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * zhenghao
 * 2018/4/4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    private Long uuid;

    private Map<String, Object> parameters;
}
