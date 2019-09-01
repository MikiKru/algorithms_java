package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import model.enums.Role;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
// wzorzec JavaBeans
// GET / SET
// KONSTRUKTORY
// toString

// adnotacja dodająca gettery i settery
@Data
// adnotacja dodająca konstruktor
@NoArgsConstructor
//@ToString
//@AllArgsConstructor
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
    private Set<Role> roles = new HashSet<>();
    // dodawanie roli do zbioru ról
    public void addRole(Role role){
        roles.add(role);
    }
    // odbieranie uprawnień
    public void removeRole(Role role){
        roles.remove(role);
    }
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
        return String.format("|%5d|%15s|%15s|%15s|%10.2f|%30s|",user_id, name,lastname,birthdate,salary,roles);
    }
}
