package Bai1;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo Model
        QuanlifileModel model = new QuanlifileModel();
        
        // Khởi tạo View
        QuanlifileView view = new QuanlifileView();
        
        // Khởi tạo Controller và truyền vào Model và View
        QuanlifileController controller = new QuanlifileController(model, view);
        
        // Hiển thị View
        view.setVisible(true);
    }
}
