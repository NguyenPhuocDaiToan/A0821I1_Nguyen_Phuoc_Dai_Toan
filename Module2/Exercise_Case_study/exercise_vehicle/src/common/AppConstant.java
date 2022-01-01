package common;

public interface AppConstant {
    enum TypeCar {
        TOURIST,
        BUS
    }

    interface Path {
        String CAR = "src/data/car.csv";
        String TRUCK = "src/data/truck.csv";
        String MOTOR = "src/data/motor.csv";
        String MANUFACTURE = "src/data/manufacturer.csv";
    }

    interface PlateRegex {
        String TOURIST = "^\\d{2}A-\\d{3}.\\d{2}$";
        String BUS = "^\\d{2}B-\\d{3}.\\d{2}$";
        String TRUCK = "^\\d{2}C-\\d{3}.\\d{2}$";
        String MOTOR = "^\\d{2}-\\[A-Z][0-9A-Z]-\\d{3}.\\d{2}$";
    }

    interface numberRegex {
        String isNumber = "^\\d{1}";
    }
}
