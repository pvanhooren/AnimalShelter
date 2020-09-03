import java.time.LocalDateTime;

public abstract class Animal implements Interfaces.ISellable{
    private String _name;
    private Gender _gender;
    private int _price;
    private Reservor _reservedBy;
    private Boolean _isReserved = false;

    public Boolean IsReserved(){
        return _isReserved;
    }

    public int Price(){
        return _price;
    }

    public Reservor ReservedBy(){
        return _reservedBy;
    }

    public String Name(){
        return _name;
    }

    public Gender Gender(){
        return _gender;
    }

    public Boolean Reserve(String reservedBy)
    {
        if (this._reservedBy == null)
        {
            this._reservedBy = new Reservor(reservedBy, LocalDateTime.now());
            _isReserved = true;
            return true;
        }
        return false;
    }

    public void Retrieve(String name, int Price){
        Price = this._price;
        name = this._name;
    }

    public void Update(int Price){
        this._price = Price;
    }

    public Animal(String name, Gender gender)
    {
        this._name = name;
        this._gender = gender;
    }

    public String toString()
    {
        String reserved = "not reserved";
        if (this._reservedBy != null)
        {
            reserved = "reserved by " + this._reservedBy.Name;
        }
        return this._name + "," + this._gender + "," + reserved + " , price: €" + this._price;
    }
}
