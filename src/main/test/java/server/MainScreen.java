package server;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {

    public static void run() {
        createAndShowGUI();
    }

    public static void addComponentsToPane(Container pane, int width, int height) {
        String defaultText = "Welcome " + StartServer.user + " Your role: " + StartServer.role;
        pane.setLayout(new MigLayout());
        pane.setPreferredSize(new Dimension(width, height));
        JLabel info_user = new JLabel(defaultText);
        pane.add(info_user, "cell 2 20 0 20");
        JLabel user_label = new JLabel("Tomcat user: ");
        pane.add(user_label, "cell 0 1");
        JTextField user_text = new JTextField(StartServer.user);
        user_text.setMaximumSize(new Dimension(115, 25));
        user_text.setPreferredSize(new Dimension(115, 25));
        pane.add(user_text, "cell 1 1");
        JLabel role_label = new JLabel("User role: ");
        pane.add(role_label, "cell 2 1");
        JTextField role_text = new JTextField(StartServer.role);
        role_text.setPreferredSize(new Dimension(115, 25));
        pane.add(role_text);
        JButton button = new JButton("Change");
        button.setPreferredSize(new Dimension(50, 30));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                StartServer.user = user_text.getText();
                StartServer.role = role_text.getText();
                String temp = "You change user: " + StartServer.user + " Your role: " + StartServer.role;
                info_user.setText(temp);
            }
        });
        pane.add(button, "gap 10");
    }

    private static void createAndShowGUI() {
        JFrame main_window = setMainWindow();

        //Display the window.
        main_window.pack();
        main_window.setVisible(true);
    }

    private static JFrame setMainWindow() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up main window.
        JFrame window = new JFrame("TOMCAT TEST SERVER web directory:    " + StartServer.webappDirLocation);
        window.setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(false);
        window.setLocationRelativeTo(null);
        //Set up the content pane and set width and height.
        addComponentsToPane(window.getContentPane(), 500, 300);
        return window;


    }
}