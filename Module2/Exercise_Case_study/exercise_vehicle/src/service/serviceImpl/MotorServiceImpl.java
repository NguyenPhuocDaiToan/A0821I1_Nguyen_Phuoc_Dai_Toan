package service.serviceImpl;

import common.AppConstant.*;
import common.FileHelper;
import model.Motor;
import service.MotorService;

import java.util.ArrayList;
import java.util.List;

public class MotorServiceImpl implements MotorService {
    private List<Motor> motorList = new ArrayList<>();
    private FileHelper<Motor> fileHelper = new FileHelper<>();

    public MotorServiceImpl() {
        motorList = getFromFile();
    }
    @Override
    public void add(Motor motor) {
        motorList.add(motor);
        fileHelper.write(Path.MOTOR, motorList, true);
    }

    @Override
    public boolean delete(String numberPlate) {
        boolean check = motorList.removeIf(e -> e.getNumberPlate().equals(numberPlate));
        fileHelper.write(Path.MOTOR, motorList, false);
        return check;
    }

    @Override
    public List<Motor> getAll() {
        return motorList;
    }

    @Override
    public List<Motor> getFromFile() {
        List<Motor> res = new ArrayList<>();
        List<String> lines = fileHelper.read(Path.MOTOR);
        if(lines.size() > 0) {
            for(String line : lines) {
                String[] temp = line.split(",");
                String numberPlate = temp[0];
                String manufacturer = temp[1];
                int year = Integer.parseInt(temp[2]);
                String owner = temp[3];
                double wattage = Double.parseDouble(temp[4]);
                Motor motor = new Motor(numberPlate, manufacturer, year, owner, wattage);
                res.add(motor);
            }
        }
        return res;
    }
}
