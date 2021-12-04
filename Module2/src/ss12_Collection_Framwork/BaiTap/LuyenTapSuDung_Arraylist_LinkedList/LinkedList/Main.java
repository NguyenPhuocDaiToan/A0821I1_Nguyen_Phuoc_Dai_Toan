package ss12_Collection_Framwork.BaiTap.LuyenTapSuDung_Arraylist_LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct();
        productManager.addProduct();
        productManager.addProduct();
        productManager.addProduct();
        productManager.displayProducts();
        if(!productManager.deleteProduct(1)) {
            System.out.println("Id không tồn tại");
        }
        productManager.sortAscendingByPrice();
        productManager.displayProducts();
    }
}
