package Bai1;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class QuanlifileController implements ActionListener {
    private QuanlifileModel model;
    private QuanlifileView view;

    public QuanlifileController(QuanlifileModel model, QuanlifileView view) {
        this.model = model;
        this.view = view;

        // Thêm action listener cho các nút trong view
        view.getInputButton().addActionListener(this);
        view.getCopyButton().addActionListener(this);
        view.getMoveButton().addActionListener(this);
        view.getCreateFileButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getInputButton()) {
            // Xử lý khi nhấn nút Chọn
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                view.getInputField().setText(selectedFile.getAbsolutePath());
                listFiles(selectedFile);
            }
        } else if (e.getSource() == view.getCopyButton()) {
            // Xử lý khi nhấn nút Sao Chép
            File selectedFile = view.getFileList().getSelectedValue();
            if (selectedFile != null) {
                // Thực hiện sao chép file
            }
        } else if (e.getSource() == view.getMoveButton()) {
            // Xử lý khi nhấn nút Di Chuyển
            File selectedFile = view.getFileList().getSelectedValue();
            if (selectedFile != null) {
                // Thực hiện di chuyển file
            }
        } else if (e.getSource() == view.getCreateFileButton()) {
            // Xử lý khi nhấn nút Tạo Tệp
            // Không cần thực hiện gì ở đây vì việc tạo NewFileUI sẽ được xử lý bên QuanlifileView
        }
    }

    // Phương thức để hiển thị danh sách tệp trong thư mục
    private void listFiles(File directory) {
        view.getListModel().clear();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    view.getListModel().addElement(file);
                }
            }
        }
    }

    // Phương thức để hiển thị nội dung của tệp trong JTextArea
    private void displayFileContent(File file) {
        try {
            String content = model.readFileContent(file);
            view.getFileContentTextArea().setText(content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Lỗi khi đọc nội dung tệp: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}
