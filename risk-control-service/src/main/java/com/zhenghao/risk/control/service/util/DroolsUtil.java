package com.zhenghao.risk.control.service.util;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Collection;
import java.util.Map;

/**
 * zhenghao
 * 2018/4/4
 */
public class DroolsUtil {

    private static KieContainer kieContainer;

    public static KieSession getSession(String scene) {
        KieSession kieSession = kieContainer.newKieSession(scene);

        return kieSession;
    }

    public static void refresh(Map<String, String> scenes) {
        KieServices kieServices = KieServices.get();

        ReleaseId releaseId = kieServices.newReleaseId("com.zhenghao", "risk-control", "1.0.0");

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.generateAndWritePomXML(releaseId);
        scenes.forEach((name, drlStr) -> {
            String fileName = "src/main/resources/" + name + "/" + name + ".drl";
            kieFileSystem.write(fileName, drlStr);
        });
        kieFileSystem.writeKModuleXML(createKieModuleModel(kieServices, scenes.keySet()).toXML());

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException(kieBuilder.getResults().toString());
        }

        kieContainer = kieServices.newKieContainer(releaseId);
    }

    private static KieModuleModel createKieModuleModel(KieServices ks, Collection<String> scenes) {
        KieModuleModel kieModuleModel = ks.newKieModuleModel();

        scenes.forEach(scene -> kieModuleModel.newKieBaseModel(scene).addPackage(scene).newKieSessionModel(scene));

        return kieModuleModel;
    }
}
