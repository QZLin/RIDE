package model.tool.generator;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import model.QFileManager;

import static model.data.weapon_xml;

public class weapon extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);

        assert project != null;
        QFileManager qFileManager = new QFileManager(project.getBasePath());
        qFileManager.createFile("data/weapon.xml", weapon_xml, project);

        QFileManager.synchronize(event);
    }

}