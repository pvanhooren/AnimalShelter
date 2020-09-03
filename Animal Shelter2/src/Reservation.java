import java.util.ArrayList;

public class Reservation {
    private ArrayList<Animal> _animals = new ArrayList<Animal>();
    static int DogsAdded;

    public ArrayList<Animal> Animals(){
        return _animals;
    }

    public void RemoveAnimal(Animal a){
        _animals.remove(a);
    }

    public void NewCat(String name, Gender gender, String badHabits)
    {
        this._animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender)
    {
        DogsAdded++;
        this._animals.add(new Dog(name, gender, DogsAdded));
    }
}
