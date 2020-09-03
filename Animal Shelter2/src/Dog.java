import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dog extends Animal {
    private LocalDateTime _lastWalk;
    private int _price;

    public LocalDateTime LastWalk(){
        return _lastWalk;
    }

    public int Price(){
        return _price;
    }

    public Boolean NeedsWalk()
    {
        return (Duration.between(LocalDateTime.now(), this._lastWalk).toDays()) > 0;
    }

    public Dog(String name, Gender gender, int dogsAdded)
    {
        super(name,gender);
        this._lastWalk = LocalDateTime.now();
        this._price = 500 - (50*(dogsAdded-1));
        if(_price < 50){ _price = 50;}
        super.Update(_price);
    }

    public @Override String toString()
    {
        return super.toString() +
                ", last walk: " + this._lastWalk.toLocalTime().toString().substring(0,5);
    }
}
