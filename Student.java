//note
package StudentManagerment;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private int age;
    private String name;
    private String address;
    private double gpa;
    
    public Student() {
    }
    public Student(int id, String name, int age, String address, double d) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = d;
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
    public void setName(String i) {
        this.name = i;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String toString() {
        return "{id=" + id + " , name=" + name + ", "
                + "address= " + address + ", age =" + age+ ", gpa ="+gpa+"}";
    }

}
