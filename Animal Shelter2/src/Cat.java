public class Cat extends Animal {
    private String _badHabits;
    private int _price;

    public String BadHabits(){
        return _badHabits;
    }

    public int Price(){
        return _price;
    }

    public Cat(String name, Gender gender, String badHabits)
    {
        super(name,gender);
        this._badHabits = badHabits;
        this._price = 350 - (20 * badHabits.length());
        if(_price<35){ _price = 35; }
        super.Update(_price);
    }

    public @Override String toString()
    {
        return super.toString() +
                ", bad habits:" + this._badHabits.toLowerCase();

    }
}
