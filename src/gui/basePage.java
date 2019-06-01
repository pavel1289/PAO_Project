package gui;

import model.User;
import service.UserService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class basePage extends JFrame{
    private JButton createNewFileButton;
    private JButton printFilesButton;
    private JTextField loginNameField;
    private JPanel rootPanel;
    private static basePage single;

    public static basePage getInstance() {
        if (single == null) {
            synchronized (basePage.class) {
                if (single == null)
                    single = new basePage();
            }
        }
        return single;
    }

    private basePage() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(rootPanel);
        setSize(400, 500);
        UserService userService = UserService.getInstance("", "");
        createNewFileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createNewFile nf = createNewFile.getInstance();
            }
        });
        printFilesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String loginName = loginNameField.getText();
                User user = userService.getUserByLoginName(loginName);
                if (user != null) {
                    user.printFiles();
                }
            }
        });
        setVisible(true);
    }
}
