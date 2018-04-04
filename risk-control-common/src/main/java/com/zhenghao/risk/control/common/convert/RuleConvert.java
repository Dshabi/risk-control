package com.zhenghao.risk.control.common.convert;

import com.zhenghao.risk.control.common.model.RulePO;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.Rule;

public class RuleConvert {

    public static Rule fromPO(RulePO rulePO) {
        return ModelHelper.map(rulePO, Rule.class);
    }

    public static RulePO toPO(Rule rule) {
        return ModelHelper.map(rule, RulePO.class);
    }
}
