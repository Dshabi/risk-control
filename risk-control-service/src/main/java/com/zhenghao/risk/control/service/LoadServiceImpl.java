package com.zhenghao.risk.control.service;

import com.zhenghao.risk.control.logic.ComposeDrlManagement;
import com.zhenghao.risk.control.service.util.DroolsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * zhenghao
 * 2018/4/4
 */
@Service
public class LoadServiceImpl {

    @Autowired
    private ComposeDrlManagement composeDrlManagement;

    public void refresh() {
        Map<String, String> scenes = composeDrlManagement.composeAllDrls();
        DroolsUtil.refresh(scenes);
    }

    @PostConstruct
    public void initializeKieContainer() {
        refresh();
    }
}
