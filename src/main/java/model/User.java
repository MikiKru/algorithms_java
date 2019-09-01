package model;

import java.time.LocalDate;
// wzorzec JavaBeans
// GET / SET
// KONSTRUKTORY
// toString
public class User {
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private Double salary;
    private boolean activity;

    public User() {}
    public User(String name, String lastname, LocalDate birthdate, Double salary, boolean activity) {
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.salary = salary;
        this.activity = activity;
    }
    @Override
    public String toString() {
        return String.format("|%15s|%15s|%15s|%10.2f|",name,lastname,birthdate,salary);
    }

    public boolean isActivity() {
        return activity;
    }
    public void setActivity(boolean activity) {
        this.activity = activity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
