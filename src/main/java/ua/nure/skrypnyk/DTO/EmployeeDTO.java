package ua.nure.skrypnyk.DTO;

import ua.nure.skrypnyk.model.Entity;

import java.util.Date;

public class EmployeeDTO extends Entity<Integer> {
    private String name;
    private String lastName;
    private Date DOB;
    private String education;
    private int positionId;
    private double salary;

    public EmployeeDTO() {

    }

    public EmployeeDTO(String name, String lastName, Date DOB, String education, int positionId, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.DOB = DOB;
        this.education = education;
        this.positionId = positionId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", education='" + education + '\'' +
                ", positionId=" + positionId +
                ", salary=" + salary +
                '}';
    }
}