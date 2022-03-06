package util;

public interface ConstantUtil {
    enum RentType {
        YEAR,
        MONTH,
        DAY,
        HOUR
    }

    enum RoomType {
        STANDARD,
        SUPERIOR,
        DELUXE,
        SUITE,
        PRESIDENTIAL
    }

    enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }

    enum TypeCustomer {
        DIAMOND,
        PLATINIUM,
        GOLD,
        SILVER,
        MEMBER
    }

    enum Degree {
        INTERMEDIATE,
        ASSOCIATE,
        BACHERLOR,
        MASTER,
        DOCTER,
        PROFESSOR
    }

    enum Position {
        RECEPTIONIST,
        ATTENDANT,
        SUPERVISOR,
        SECURITY,
        HR,
        SALES,
        DIRECTOR,
        CHEF,
        MANAGER
    }
    interface PATH {
        String EMPLOYEE = "src/data/employee.csv";
        String CUSTOMER = "data/customer.csv";
    }
}
