import controller.CollectionController;
import model.User;
import model.enums.Role;

import java.time.LocalDate;
import java.util.*;

public class MapMain {
    public static void main(String[] args) {
//        Map<Integer, User> usersMap = new HashMap<>();
//        usersMap.put(1,new User(
//                "Michał",
//                "Kruczkowski",
//                LocalDate.of(2000,01,01),
//                9999.99,
//                true));
//        usersMap.put(2,new User(
//                "Adam",
//                "Kowalski",
//                LocalDate.of(1900,01,01),
//                19999.99,
//                true));
//        usersMap.put(2,new User(
//                "Jan",
//                "Nowak",
//                LocalDate.of(1900,01,01),
//                19999.99,
//                true));
//        usersMap.forEach((integer, user) -> System.out.println(user.toString()));
//        System.out.println(usersMap.get(2));
//        System.out.println(usersMap.keySet());
//        System.out.println(usersMap.values());
        System.out.println("XXXXXXXXXXXXXXXXXXXXX");

        Map<String, User>usersMapSorted = new TreeMap<String, User>(Comparator.comparing(String::length));
        usersMapSorted.put("pierwszy",new User(
                "Michał",
                "Kruczkowski",
                LocalDate.of(2000,01,01),
                9999.99,
                true));
        usersMapSorted.put("drugi",new User(
                "Adam",
                "Kowalski",
                LocalDate.of(1900,01,01),
                19999.99,
                true));
        usersMapSorted.put("trzeci",new User(
                "Jan",
                "Nowak",
                LocalDate.of(1900,01,01),
                19999.99,
                true));
        usersMapSorted.forEach((integer, user) -> System.out.println("key="+integer + " | " +user.toString()));

        User user1 = new User();
        user1.setUser_id(2);
        User user2 = new User();
        user2.setUser_id(5);
        User user3 = new User();
        user3.setUser_id(1);
        Set<Integer> users = new TreeSet<>(Arrays.asList(
                user1.getUser_id(), user2.getUser_id(), user3.getUser_id(), user2.getUser_id()
        ));
        System.out.println(users);

    }
}
