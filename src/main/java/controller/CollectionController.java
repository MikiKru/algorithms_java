package controller;

import model.User;

import java.time.LocalDate;
import java.util.*;

public class CollectionController {
    // Lista obiektów klasy modelu
    private List<User> users = new ArrayList<>();

    public void addUser(String name, String lastname, LocalDate birthdate, Double salary){
        // dodanie użytkownika do listy
        users.add(new User(name, lastname, birthdate, salary, true));
        System.out.println("Dodano użtkownika");
    }
    public User findUserById(int user_id){
        for(User user : users){
            if(user_id == user.getUser_id()){
                return user;
            }
        }
        return null;
    }
    public Optional<User> findUserByIdStream(int user_id){
        // kolekcja -> zamiana na strumień -> filtrujemy po id -> zwracamy optional z zanalezioną wartością lub null
        return users.stream().filter(user -> user.getUser_id()==user_id).findAny();
    }
    public void deleteUserById(int user_id){
        // jeżeli w optionalu jest wartośń nie nullowa
        if(findUserByIdStream(user_id).isPresent()){
            // pobierz zawartość optionala i podaj ją jako argument do metody remove
            users.remove(findUserByIdStream(user_id).get());
        }
    }
    public void updateUserById(int user_id, double percent){
        if(findUserByIdStream(user_id).isPresent()){
            User user = findUserByIdStream(user_id).get();
            // podwyżka
            user.setSalary(user.getSalary() * (1 + percent));
            // pobranie indeksu na którym zapisany jest obiekt
            int index = users.indexOf(user);
            // aktualizacja bazy danych
            users.set(index,user);
        }

    }

    public void getUsers(){
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("XXXXXXXXXXXXXXXXXXXXX");
    }

}
