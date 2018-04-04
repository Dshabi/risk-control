package com.zhenghao.risk.control.contract.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NormalParameter {

    private Long id;

    private String name;

    private String dataType;

    private Long attributeId;
}
