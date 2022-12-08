package common.serialize;

public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.printf("employee info: \n name = %s\n address = %s\n ssn(transient) = %d\n number = %d \n", name, address, SSN, number);
    }
}
