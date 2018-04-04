package com.zhenghao.risk.control.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Condition {

    private Long id;

    private String leftCategory;

    private String leftValue;

    private String rightCategory;

    private String rightValue;

    private String comparator;
}
