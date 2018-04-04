package com.zhenghao.risk.control.common.convert;


import com.zhenghao.risk.control.common.model.NormalParameterPO;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.NormalParameter;

public class NormalParameterConvert {

    public static NormalParameter fromPO(NormalParameterPO NormalParameterPO) {
        return ModelHelper.map(NormalParameterPO, NormalParameter.class);
    }

    public static NormalParameterPO toPO(NormalParameter NormalParameter) {
        return ModelHelper.map(NormalParameter, NormalParameterPO.class);
    }
}
