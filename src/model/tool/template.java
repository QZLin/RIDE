package model.tool;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import model.QFileManager;

import static model.data.mod_xml;

public class template extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);

        assert project != null;
        QFileManager qFileManager = new QFileManager(project.getBasePath());

        qFileManager.createDirection("additional/data", project);
        qFileManager.createDirection("data", project);
        qFileManager.createFile("data/mod.xml", mod_xml, project);

        QFileManager.synchronize(event);
    }

}