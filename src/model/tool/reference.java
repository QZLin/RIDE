package model.tool;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import model.LangL18n;

import java.io.IOException;

public class reference extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        assert project != null;

        String sdkPath = project.getBasePath();
        assert sdkPath != null;
        for (int i = 0; i < 2; i++) {
            int lastIndex = sdkPath.lastIndexOf("/");
            if (lastIndex == -1) {
                return;
            }

            sdkPath = sdkPath.substring(0, lastIndex);
        }
        //Get sagexml folder
        String xmlPath = sdkPath + "/" + "SageXml";
        //Convert path to windows format
        xmlPath = xmlPath.replace('/', '\\');

        //Call explorer
        try {
            Runtime.getRuntime().exec("explorer " + xmlPath);
        } catch (IOException e) {
            LangL18n lang = new LangL18n();
            Messages.showErrorDialog(lang.get("sagexml_not_found"), lang.get("error"));
        }
    }

}