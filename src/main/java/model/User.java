package model;

import model.enums.Role;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
// wzorzec JavaBeans
// GET / SET
// KONSTRUKTORY
// toString
public class User {
    // pole statyczne związane z klasą User
    private static int id = 1;
    // pole obiektowe związane z instancją kalsy user
    private int user_id;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private Double salary;
    private boolean activity;
    // zbiór ról
    Set<Role> roles = new HashSet<>();

    // dodawanie roli do zbioru ról

    // odbieranie uprawnień


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {}
    public User(String name, String lastname, LocalDate birthdate, Double salary, boolean activity) {
        this.user_id = id++;
        this.name = name;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.salary = salary;
        this.activity = activity;
    }
    @Override
    public String toString() {
        return String.format("|%5d|%15s|%15s|%15s|%10.2f|",user_id, name,lastname,birthdate,salary);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
