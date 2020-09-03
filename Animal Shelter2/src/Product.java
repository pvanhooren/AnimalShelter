import Interfaces.ISellable;

public class Product implements ISellable {
    private int _price;
    private String _name;

    public Product(int Price, String Name){
        _price = Price;
        _name = Name;
    }

    public int Price(){
        return _price;
    }

    public String Name(){
        return _name;
    }

    public void Retrieve(String Name, int Price){
        this._name = Name;
        this._price = Price;
    }

    public void Update(int Price){
        Price = this._price;
    }

    public String toString(){
        return this._name + " , Price: €" + this._price;
    }
}
