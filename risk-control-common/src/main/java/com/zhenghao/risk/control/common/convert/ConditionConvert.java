package com.zhenghao.risk.control.common.convert;

import com.zhenghao.risk.control.common.model.ConditionPO;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.Condition;

public class ConditionConvert {

    public static Condition fromPO(ConditionPO conditionPO) {
        return ModelHelper.map(conditionPO, Condition.class);
    }

    public static ConditionPO toPO(Condition condition) {
        return ModelHelper.map(condition, ConditionPO.class);
    }
}
