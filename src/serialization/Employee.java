package serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    public Employee(String name, String companyName, Double salary, String password) {
        this.name = name;
        this.companyName = companyName;
        this.salary = salary;
        this.password = password;
    }

    private String name;
    private String companyName;
    private transient Double salary;
    private String password;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
