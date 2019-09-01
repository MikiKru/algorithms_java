import controller.CollectionController;

import java.time.LocalDate;

public class CollectionMain {
    public static void main(String[] args) {
        // inicjalizacja klasy kontrolera
        CollectionController cc = new CollectionController();
        // dodawanie użytkowników do bazy
        cc.addUser("Michał","Kruczkowski", LocalDate.of(2000,01,01),9999.99);
        cc.addUser("Anna","Nowak", LocalDate.of(2010,01,01),999.99);
        cc.addUser("Jan","Jankowski", LocalDate.of(2001,01,01),19999.99);
        cc.addUser("Adam","Kowalski", LocalDate.of(2002,01,01),8899.99);
        // wypisanie zawartości bazy
        cc.getUsers();
        // usunięcie użytkownika
        cc.deleteUserById(2);
        // zmiana pensji
        cc.updateUserById(1, 0.5);
        // wypisanie listy użytkowników
        cc.getUsers();
    }
}
