package com.zhenghao.risk.control.service;

import com.zhenghao.risk.control.contract.vo.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * zhenghao
 * 2018/4/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceContext.class)
@ActiveProfiles("default")
public class RuleEngineServiceImplTest {

    @Autowired
    private RuleEngineServiceImpl ruleEngineService;

    @Test
    public void execute() throws Exception {
        Event event = new Event();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("scene", "yifenlake");
        parameters.put("uid", "haha");
        parameters.put("age", 18);

        event.setParameters(parameters);

        ruleEngineService.execute(event);

        System.out.println(event);
    }

}