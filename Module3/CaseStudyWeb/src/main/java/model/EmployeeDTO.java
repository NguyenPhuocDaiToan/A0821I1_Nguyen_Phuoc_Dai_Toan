package model;

public class EmployeeDTO {
    int id;
    String name;
    String birthday;
    String idCard;
    double salary;
    String phone;
    String email;
    String address;
    int positionId;
    String positionName;
    int educationDegreeId;
    String educationDegreeName;
    int divisionId;
    String divisionName;
    String userName;

    public EmployeeDTO() {

    }

    public EmployeeDTO(String name, String birthday, String idCard, double salary, String phone, String email,
                       String address, int positionId, String positionName, int educationDegreeId,
                       String educationDegreeName, int divisionId, String divisionName, String userName) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.positionName = positionName;
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.userName = userName;
    }

    public EmployeeDTO(int id, String name, String birthday, String idCard, double salary, String phone, String email,
                       String address, int positionId, String positionName, int educationDegreeId,
                       String educationDegreeName, int divisionId, String divisionName, String userName) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positionId = positionId;
        this.positionName = positionName;
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.userName = userName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
