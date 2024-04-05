package Bai1;

import java.io.*;
import java.nio.file.Files;

public class QuanlifileModel {
    public void copyFile(File source, File destinationDirectory) throws IOException {
        // Sao chép tệp từ nguồn đến thư mục đích
        Files.copy(source.toPath(), new File(destinationDirectory, source.getName()).toPath());
    }

    public String readFileContent(File file) throws IOException {
        // Đọc nội dung của tệp và trả về dưới dạng chuỗi
        return new String(Files.readAllBytes(file.toPath()));
    }
}
