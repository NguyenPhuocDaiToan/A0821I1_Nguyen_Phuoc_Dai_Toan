package ss5_AccessModifier_Static.BaiTap.WriteOnlyClass;

public class Student {
    private String name = "John";
    private String classes = "CO2";
    Student(){}
    public void setName(String name) {
        this.name = name;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
    public void dislay() {
        System.out.println(this.name + " " +  this.classes);
    }
}
