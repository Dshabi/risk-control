package com.zhenghao.risk.control.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collocation {

    private Long id;

    private Long sceneId;

    private Long ruleId;

    private String returnCode;

    private Integer priority;

    private String status;

    private Scene scene;

    private Rule rule;
}
