package model;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class QFileManager {
    private String root;

    public QFileManager(String root) {
        this.root = root + "/";
    }

    public void createFile(String path, String text, Project project) {
        path = root + path;
        File file = new File(path);

        if (file.exists()) {
            int answer = Messages.showOkCancelDialog(project, "Do you want to override the file \"" + path + "\"?",
                    "Override Warning", "Override", "Cancel", Messages.getQuestionIcon());
            if (answer != Messages.OK) {
                return;
            }

        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

            outputStreamWriter.write(text);

            outputStreamWriter.close();
        } catch (IOException e) {
            System.out.println(String.format("File `%s` Create error!", path));
        }
    }

    public void createDirection(String path, Project project) {
        path = root + path;

        java.io.File file = new java.io.File(path);

        if (file.exists()) {
            int answer = Messages.showOkCancelDialog(project, "Do you want to override the folder \"" + path + "\"?",
                    "Generate", "Override", "Cancel", Messages.getQuestionIcon());
            if (answer != Messages.OK) {
                return;
            }

        }

        file.mkdirs();
    }

    static public void synchronize(AnActionEvent event) {
        AnAction anAction = ActionManager.getInstance().getAction("Synchronize");
        anAction.actionPerformed(event);
    }
}


