package com.zhenghao.risk.control.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rule {

    private Long id;

    private String name;

    private String description;

    private String logicMode;

    private String relConditionIds;

    private List<Condition> conditions;

    private String returnCode;

    private Integer priority;

    private String status;
}
