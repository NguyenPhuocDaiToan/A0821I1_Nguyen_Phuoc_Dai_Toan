package ss7_Abstract_Interface.ThucHanh.Animal_Interface_Edible.Model;

import ss7_Abstract_Interface.ThucHanh.Animal_Interface_Edible.Model.Animal;
import ss7_Abstract_Interface.ThucHanh.Animal_Interface_Edible.Service.IEdible;

public class Tiger extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howtoEat() {
        return "Tiger could be fried";
    }
}
