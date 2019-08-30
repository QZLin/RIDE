package model.tool;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class win_options {

    private static JFrame frame;
    private JPanel Panel;
    private JPanel subPanel;
    private JButton OKButton;

    private win_options() {
        OKButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setVisible(false);
            }
        });
    }

    static void Show() {
        frame = new JFrame("win_options");
        frame.setTitle("Build Options");
        frame.setContentPane(new win_options().Panel);
        frame.setAlwaysOnTop(true);
        frame.pack();
        frame.setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
            }

        });


    }
}
