import java.util.ArrayList;

public class Webshop {
    private ArrayList<Product> _products = new ArrayList<Product>();

    public ArrayList<Product> Products(){
        return _products;
    }

    public void NewProduct(int Price, String Name){
        Product p = new Product(Price, Name);
        _products.add(p);
    }

    public void RemoveProducts(Product p){
        _products.remove(p);
    }
}
