package com.zhenghao.risk.control.logic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * zhenghao
 * 2018/4/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogicContext.class)
@ActiveProfiles("default")
public class ComposeDrlManagementTest {

    @Autowired
    private ComposeDrlManagement composeDrlManagement;

    @Test
    public void composeAllDrls() throws Exception {
        composeDrlManagement.composeAllDrls().values().forEach(System.out::println);
    }

}