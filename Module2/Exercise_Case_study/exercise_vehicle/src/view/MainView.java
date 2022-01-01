package view;

import common.AppConstant.*;
import common.FileHelper;
import exception.NotFoundVehicelException;
import model.Car;
import model.Motor;
import model.Truck;
import service.serviceImpl.CarServiceImpl;
import service.serviceImpl.MotorServiceImpl;
import service.serviceImpl.TruckServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainView {
    private static Scanner scanner = new Scanner(System.in);
    private static Pattern pattern;
    private static Matcher matcher;
    private static TruckServiceImpl truckService = new TruckServiceImpl();
    private static CarServiceImpl carService = new CarServiceImpl();
    private static MotorServiceImpl motorService = new MotorServiceImpl();

    private static FileHelper<String> fileHelper = new FileHelper<>();
    public static void main(String[] args) {
        displayMainMenu();
    }
    private static void displayMainMenu() {
        System.out.println("\t1. Add new vehicle\n\t2. Display list vehicles\n\t3. Delete vehicle\n\t4. Exit");
        int choice = inputChoice(4);
        switch (choice) {
            case 1:
                add();
                break;
            case 2:
                display();
                break;
            case 3:
                delete();
                break;
            case 4:
                System.exit(0);
                break;
        }
        backToMenu();
    }


    private static void add() {
        System.out.println("\t1. Add truck\n\t2. Add car\n\t3. Add motor");
        int choice = inputChoice(3);
        List<String> res = new ArrayList<>();
        switch (choice) {
            case 1:
                boolean isTruckPlate;
                String truckPlate = "";
                do {
                    isTruckPlate = true;
                    System.out.print("Input number truck plate with format XXC-XXX.XX: ");
                    truckPlate = scanner.nextLine();
                    isTruckPlate = checkTruckPlate(truckPlate);
                } while (!isTruckPlate);
                res = inputCommon();
                System.out.print("Input load: ");
                double load = Integer.parseInt(scanner.nextLine());

                Truck truck = new Truck(truckPlate, res.get(0), Integer.parseInt(res.get(1)), res.get(2), load);
                truckService.add(truck);
                break;
            case 2:
                String typeCar = "";
                boolean isTypeCar;
                do {
                    isTypeCar = true;
                    System.out.print("Input type car BUS or TOURIST: ");
                    typeCar = scanner.nextLine();
                    isTypeCar = checkTypeCar(typeCar);
                } while(!isTypeCar);

                String carPlate = "";
                boolean isCarPlate;;
                boolean isBus = typeCar.equalsIgnoreCase("BUS");
                do {
                    System.out.print(isBus ? "Input number BUS plate with format XXB-XXX.XX (X: 0-9): "
                            : "Input number TOURIST plate with format XXA-XXX.XX (X: 0-9): ");
                    carPlate = scanner.nextLine();
                    isCarPlate = checkCarPlate(carPlate, isBus);
                } while (!isCarPlate);
                res = inputCommon();
                System.out.print("Input numbet seat: ");
                int seat = Integer.parseInt(scanner.nextLine());
                Car car = new Car(carPlate, res.get(0), Integer.parseInt(res.get(1)), res.get(2), seat, TypeCar.valueOf(typeCar.toUpperCase()));
                carService.add(car);
                break;
            case 3:
                boolean isMotorPlate;
                String motorPlate;
                do {
                    isMotorPlate = true;
                    System.out.print("Input number motor plate with format XX-YZ-XXX.XX (X: 0-9; Y: A-Z; Z:0-9A-Z):");
                    motorPlate = scanner.nextLine();
                    isMotorPlate = checkMotorPlate(motorPlate);
                } while (!isMotorPlate);

                res = inputCommon();
                double wattage = Double.parseDouble(scanner.nextLine());
                Motor motor = new Motor(motorPlate, res.get(0), Integer.parseInt(res.get(0)), res.get(1), wattage);
                motorService.add(motor);
                break;
        }
        System.out.println("Add successful");
    }

    private static void display() {
        System.out.println("\t1. Display list trucks\n\t2. Display list cars\n\t3. Display motor");
        int choice = inputChoice(3);
        switch (choice) {
            case 1:
                List<Truck> trucks = truckService.getAll();
                System.out.println("                       --------------- LIST TRUCKS ---------------");
                System.out.printf("%-20s %-20s %-10s %-20s %-10s\n", "NUMBER PLATE", "MANUFACTURE", "YEAR", "OWNER", "LOAD");
                for (Truck truck : trucks) {
                    System.out.printf("%-20s %-20s %-10d %-20s %-10f\n", truck.getNumberPlate(), truck.getManufacturer()
                            , truck.getYear(), truck.getOwner(), truck.getLoad());
                }
                break;
            case 2:
                List<Car> cars = carService.getAll();
                System.out.println("                      --------------- LIST CARS ---------------");
                System.out.printf("%-20s %-20s %-20s %-10s %-20s %-10s\n", "NUMBER PLATE", "TYPECAR", "MANUFACTURE", "YEAR", "OWNER", "SEAT");
                for (Car car : cars) {
                    System.out.printf("%-20s %-20s %-20s %-10d %-20s %-10d\n", car.getNumberPlate(), car.getTypeCar()
                            , car.getManufacturer(), car.getYear(), car.getOwner(), car.getNumberSeat());
                }
                break;
            case 3:
                List<Motor> motors = motorService.getAll();
                System.out.println("                       --------------- LIST MOTORS ---------------");
                System.out.printf("%-20s %-20s %-10s %-20s %-10s\n", "NUMBER PLATE", "MANUFACTURE", "YEAR", "OWNER", "LOAD");
                for (Motor motor : motors) {
                    System.out.printf("%-20s %-20s %-10d %-20s %-10f\n", motor.getNumberPlate(), motor.getManufacturer()
                            , motor.getYear(), motor.getOwner(), motor.getWattage());
                }
                break;
        }
    }

    private static void delete() {
        boolean isSuccessfull = false;
        boolean checkAnswer;
        String answer;
        do {
            try {
                System.out.print("Input number plate to delete: ");
                String numberPlate = scanner.nextLine();
                System.out.print("Do you sure to delete (Y/N): ");
                answer = scanner.nextLine();
                if(answer.equalsIgnoreCase("Y")) {
                    isSuccessfull = carService.delete(numberPlate);
                    if(!isSuccessfull) isSuccessfull = truckService.delete(numberPlate);
                    if(!isSuccessfull) isSuccessfull = motorService.delete(numberPlate);
                    if(!isSuccessfull)  throw new NotFoundVehicelException("Number plate is not exists");
                    System.out.println("Delete successfull !!!");
                }
                else isSuccessfull = true;
            }
            catch (NotFoundVehicelException e) {
                System.out.println(e.getMessage());
            }
        } while (!isSuccessfull);
    }

    private static List<String> inputCommon() {
        List<String> res = new ArrayList<>();
        List<String> lines = fileHelper.read(Path.MANUFACTURE);
        List<String> manufactures = new ArrayList<>();
        System.out.println("------------- LIST MANUFACTURERS -------------");
        for (String line : lines) {
            String[] tmp = line.split(",");
            System.out.printf("%-20s %-20s %-20s\n", tmp[0], tmp[1], tmp[2]);
            manufactures.add(tmp[1]);
        }
        String manufacture;
        boolean isManufacture;
        do {
            isManufacture = true;
            System.out.print("Input manufacture from list manufactures: ");
            manufacture = scanner.nextLine();
            isManufacture = manufactures.contains(manufacture);
        } while (!isManufacture);

        System.out.print("Input year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Input owner: ");
        String owner = scanner.nextLine();
        res.add(manufacture);
        res.add(String.valueOf(year));
        res.add(owner);
        return res;
    }

    private static int inputChoice(int end) {
        int choice = 0;
        String temp;
        boolean isNumber = false;
        pattern = Pattern.compile(numberRegex.isNumber);
        do {
            System.out.print("Input choice from 1 to " + end + ": ");
            temp = scanner.nextLine();
            matcher = pattern.matcher(temp);
            if(matcher.matches()) {
                choice = Integer.parseInt(temp);
                if(choice >= 1 && choice <= end)    isNumber = true;
                else isNumber = false;
            }
            else isNumber = false;
        } while (!isNumber);
        return choice;
    }

    private static boolean checkTruckPlate(String truckPlate) {
        if(truckPlate.isEmpty())    return false;
        if(truckService.getAll().stream().anyMatch(e->e.getNumberPlate().equals(truckPlate)))
            return false;
        pattern = Pattern.compile(PlateRegex.TRUCK);
        matcher = pattern.matcher(truckPlate);
        return matcher.matches();
    }

    private static boolean checkTypeCar(String typeCar) {
        if(typeCar.isEmpty())   return false;
        return Arrays.stream(TypeCar.values()).anyMatch(e -> e.name().equalsIgnoreCase(typeCar));
    }

    private static boolean checkCarPlate(String carPlate, boolean isBus) {
        if(carPlate.isEmpty())  return false;
        if(carService.getAll().stream().anyMatch(e->e.getNumberPlate().equals(carPlate)))
            return false;
        if(isBus) pattern = Pattern.compile(PlateRegex.BUS);
        else pattern = Pattern.compile(PlateRegex.TOURIST);
        matcher = pattern.matcher(carPlate);
        return matcher.matches();
    }

    private static boolean checkMotorPlate(String motorPlate) {
        if(motorPlate.isEmpty())    return false;
        if(motorService.getAll().stream().anyMatch(e->e.getNumberPlate().equals(motorPlate)))
            return false;
        pattern = Pattern.compile(PlateRegex.MOTOR);
        matcher = pattern.matcher(motorPlate);
        return matcher.matches();
    }

    private static void backToMenu() {
        System.out.print("Do you want to back to menu? (Y/N): ");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("Y"))
            displayMainMenu();
    }
}
