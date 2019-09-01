package controller;

import model.User;

import java.time.LocalDate;
import java.util.*;

public class CollectionController {
    // Lista obiektów klasy modelu
    private List<User> users = new ArrayList<>();

    public void addUser(
            String name,
            String lastname,
            LocalDate birthdate,
            Double salary){
        // dodanie użytkownika do listy
        users.add(new User(
                name,
                lastname,
                birthdate,
                salary,
                true));
        System.out.println("Dodano użtkownika");
    }
    public void getUsers(){
        for (User user : users) {
            System.out.println(user);
        }
    }

}
