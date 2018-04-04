package com.zhenghao.risk.control.service;

import com.zhenghao.risk.control.repository.dao.RuleRepository;
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
@SpringBootTest(classes = ServiceContext.class)
@ActiveProfiles("default")
public class LoadServiceImplTest {

    @Test
    public void refreshAll() throws Exception {

    }

}