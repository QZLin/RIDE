package model.tool.generator;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import model.QFileManager;

import static model.data.armor_xml;

public class armor extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);

        assert project != null;
        QFileManager qFileManager = new QFileManager(project.getBasePath());
        qFileManager.createFile("data/armor.xml", armor_xml, project);

        QFileManager.synchronize(event);
    }

}