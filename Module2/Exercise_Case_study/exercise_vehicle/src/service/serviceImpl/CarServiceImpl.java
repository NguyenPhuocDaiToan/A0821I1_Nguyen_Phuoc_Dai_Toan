package service.serviceImpl;

import common.AppConstant.*;
import common.FileHelper;
import model.Car;
import service.CarService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarServiceImpl implements CarService {
    private List<Car> carList = new ArrayList<>();
    private FileHelper<Car> fileHelper = new FileHelper<>();

    public CarServiceImpl() {
        carList = getFromFile();
    }
    @Override
    public void add(Car car) {
        carList.add(car);
        fileHelper.write(Path.CAR, carList, true);
    }

    @Override
    public boolean delete(String numberPlate) {
        boolean check = carList.removeIf(e -> e.getNumberPlate().equals(numberPlate));
        fileHelper.write(Path.CAR, carList, false);
        return check;
    }

    @Override
    public List<Car> getAll() {
        return carList;
    }

    @Override
    public List<Car> getFromFile() {
        List<Car> res = new ArrayList<>();
        List<String> lines = fileHelper.read(Path.CAR);
        if(lines.size() > 0) {
            for (String line : lines) {
                String[] temp = line.split(",");
                String numberPlate = temp[0];
                String manufacturer = temp[1];
                int year = Integer.parseInt(temp[2]);
                String owner = temp[3];
                int numberSeat = Integer.parseInt(temp[4]);
                TypeCar typeCar = TypeCar.valueOf(temp[5]);
                Car car = new Car(numberPlate, manufacturer, year, owner, numberSeat, typeCar);
                res.add(car);
            }
        }
        return res;
    }
}
