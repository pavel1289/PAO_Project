package gui;

import model.DirectoryFile;
import model.ExecutableFile;
import model.TextFile;
import model.User;
import service.UserService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class createNewFile extends JFrame{
    private JTextField fileNameField;
    private JPanel rootPanel;
    private JTextField fileTypeField;
    private JButton backHomeButton;
    private JButton createFileButton;
    private JTextField loginNameField;
    private static createNewFile single;

    public static createNewFile getInstance() {
        if (single == null) {
            synchronized (createNewFile.class) {
                if (single == null) {
                    single = new createNewFile();
                }
            }
        }
        return single;
    }

    private createNewFile() {
        UserService userService = UserService.getInstance("", "");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(rootPanel);
        setSize(400, 500);
        setVisible(true);
        createFileButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String loginName = loginNameField.getText();
                User user = userService.getUserByLoginName(loginName);
                if (user != null) {
                    DirectoryFile root = user.getRootDirectoryFile();
                    String fileName = fileNameField.getText();
                    String fileType = fileTypeField.getText();
                    if (fileType.equals("TextFile")) {
                        root.addFile(new TextFile(fileName));
                    } else if (fileType.equals("DirectoryFile")) {
                        root.addFile(new DirectoryFile(fileName));
                    } else if (fileType.equals("ExecutableFile")) {
                        root.addFile(new ExecutableFile(fileName));
                    }
                }
            }
        });
        backHomeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                basePage b = basePage.getInstance();
            }
        });
    }
}
