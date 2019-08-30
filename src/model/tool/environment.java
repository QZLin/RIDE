package model.tool;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import model.QFileManager;

import static model.data.builder_py;
import static model.data.config_py;

public class environment extends AnAction {
    private String projectPath;
    private String cfg_config_py;

    public void actionPerformed(AnActionEvent event) {
        //Get project path
        Project project = event.getData(PlatformDataKeys.PROJECT);
        assert project != null;
        projectPath = project.getBasePath();

        cfg_config_py = config_py;
        autoConfig();

        QFileManager qFileManager = new QFileManager(projectPath);
        qFileManager.createFile("builder.py", builder_py, project);
        qFileManager.createFile("config.py", cfg_config_py, project);

        QFileManager.synchronize(event);
    }

    private void autoConfig() {
        //Get sdk path by project path
        String sdkPath = projectPath;
        int i;
        for (i = 0; i < 2; i++) {
            int lastIndex = sdkPath.lastIndexOf("/");
            //If can not get sdk path by project path, return
            if (lastIndex == -1) {
                return;
            }

            sdkPath = sdkPath.substring(0, lastIndex);
        }
        //Get project folder name
        int lastIndex = projectPath.lastIndexOf("/");
        String projectFolder = projectPath.substring(lastIndex + 1);

        //replace
        cfg_config_py = cfg_config_py.replace("sdk_path = r''",
                String.format("sdk_path = r'%s'", sdkPath));
        cfg_config_py = cfg_config_py.replace("project_folder = ''",
                String.format("project_folder = '%s'", projectFolder));
    }

}
//        String txt = Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
//        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());
