package com.zhenghao.risk.control.service;

import com.zhenghao.risk.control.contract.vo.Event;
import com.zhenghao.risk.control.contract.vo.FireResult;
import com.zhenghao.risk.control.service.util.DroolsUtil;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

/**
 * zhenghao
 * 2018/4/5
 */
@Service
public class RuleEngineServiceImpl {

    public void execute(Event event) {
        FireResult fireResult = new FireResult();
        String scene = (String) event.getParameters().get("scene");
        KieSession kieSession = DroolsUtil.getSession(scene);
        kieSession.insert(event);
        kieSession.insert(fireResult);

        kieSession.fireAllRules();
        event.getParameters().put("returnCode", fireResult.getReturnCode());

        kieSession.dispose();
    }

}
