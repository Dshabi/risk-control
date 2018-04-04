package com.zhenghao.risk.control.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * zhenghao
 * 2018/4/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogicContext.class)
@ActiveProfiles("default")
public class AssembleSceneManagementTest {

    @Autowired
    private AssembleSceneManagement assembleSceneManagement;

    @Test
    public void assembleScene() throws Exception {
        assembleSceneManagement.assembleAllScenes().forEach(System.out::println);
    }

}