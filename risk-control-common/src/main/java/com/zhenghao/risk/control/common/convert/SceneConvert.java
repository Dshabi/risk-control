package com.zhenghao.risk.control.common.convert;

import com.zhenghao.risk.control.common.model.ScenePO;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.Scene;

public class SceneConvert {

    public static Scene fromPO(ScenePO scenePO) {
        return ModelHelper.map(scenePO, Scene.class);
    }

    public static ScenePO toPO(Scene scene) {
        return ModelHelper.map(scene, ScenePO.class);
    }
}
