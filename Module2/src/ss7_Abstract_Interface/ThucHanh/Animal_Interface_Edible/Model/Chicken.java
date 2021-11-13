package ss7_Abstract_Interface.ThucHanh.Animal_Interface_Edible.Model;

import ss7_Abstract_Interface.ThucHanh.Animal_Interface_Edible.Model.Animal;
import ss7_Abstract_Interface.ThucHanh.Animal_Interface_Edible.Service.IEdible;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howtoEat() {
        return "Chicken could be fried";
    }
}