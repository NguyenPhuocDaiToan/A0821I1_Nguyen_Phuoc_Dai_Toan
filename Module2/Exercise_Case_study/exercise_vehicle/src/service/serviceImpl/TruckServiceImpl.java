package service.serviceImpl;

import common.AppConstant.*;
import common.FileHelper;
import model.Truck;
import service.TruckService;

import java.util.ArrayList;
import java.util.List;

public class TruckServiceImpl implements TruckService {
    private List<Truck> truckList = new ArrayList<>();
    private FileHelper<Truck> fileHelper = new FileHelper<>();

    public  TruckServiceImpl() {
        truckList = getFromFile();
    }
    @Override
    public void add(Truck truck) {
        truckList.add(truck);
        fileHelper.write(Path.TRUCK, truckList, true);
    }

    @Override
    public boolean delete(String numberPlate) {
        boolean check = truckList.removeIf(e -> e.getNumberPlate().equals(numberPlate));
        fileHelper.write(Path.TRUCK, truckList, false);
        return check;
    }

    @Override
    public List<Truck> getAll() {
        return truckList;
    }

    @Override
    public List<Truck> getFromFile() {
        List<Truck> res = new ArrayList<>();
        List<String> lines = fileHelper.read(Path.TRUCK);
        if(lines.size() > 0) {
            for(String line : lines) {
                if(line.equals("")) return res;
                String[] temp = line.split(",");
                String numberPlate = temp[0];
                String manufacturer = temp[1];
                int year = Integer.parseInt(temp[2]);
                String owner = temp[3];
                double load = Double.parseDouble(temp[4]);
                Truck truck = new Truck(numberPlate, manufacturer, year, owner, load);
                res.add(truck);
            }
        }
        return res;
    }
}
