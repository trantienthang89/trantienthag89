package Bai1;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuanlifileView extends JFrame {
    private JTextField inputField;
    private JList<File> fileList;
    private DefaultListModel<File> listModel;
    private JButton inputButton;
    private JButton copyButton;
    private JButton moveButton;
    private JButton createFileButton;
    private JTextArea fileContentTextArea;

    public QuanlifileView() {
        setTitle("Quản Lý Tệp");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Khởi tạo các thành phần giao diện
        inputField = new JTextField();
        fileList = new JList<>();
        listModel = new DefaultListModel<>();
        fileList.setModel(listModel);
        inputButton = new JButton("Chọn");
        copyButton = new JButton("Sao Chép");
        moveButton = new JButton("Di Chuyển");
        createFileButton = new JButton("Tạo Tệp");
        fileContentTextArea = new JTextArea();

        // Thiết lập layout
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Chọn Thư Mục:"), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(inputButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(copyButton);
        buttonPanel.add(moveButton);
        buttonPanel.add(createFileButton);

        JScrollPane scrollPane = new JScrollPane(fileList);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel, BorderLayout.WEST);
        getContentPane().add(new JScrollPane(fileContentTextArea), BorderLayout.CENTER);
    }

    // Các phương thức getter cho các thành phần giao diện
    public JTextField getInputField() {
        return inputField;
    }

    public JList<File> getFileList() {
        return fileList;
    }

    public DefaultListModel<File> getListModel() {
        return listModel;
    }

    public JButton getInputButton() {
        return inputButton;
    }

    public JButton getCopyButton() {
        return copyButton;
    }

    public JButton getMoveButton() {
        return moveButton;
    }

    public JButton getCreateFileButton() {
        return createFileButton;
    }

    public JTextArea getFileContentTextArea() {
        return fileContentTextArea;
    }
}
