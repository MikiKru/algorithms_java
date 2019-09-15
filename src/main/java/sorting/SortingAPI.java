package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// CTRL + SPACJA -> LAMBDA PREDYKAT
public class SortingAPI {
    List<String> names = new ArrayList<>(
            Arrays.asList("Jan", "Alan", "Ela", "Janusz", "Anna", "Andrzej"));

    public List<String> sortByNameAsc(){
        return names.stream()
                .sorted((name1, name2) -> name1.compareTo(name2))
                .collect(Collectors.toList());
    }
    public List<String> sortByLengthDesc(){
        return names.stream()
                .sorted((name1, name2) -> String.valueOf(name2.length())
                                            .compareTo(String.valueOf(name1.length())))
                .collect(Collectors.toList());
    }
    public List<Integer> sortByLengthDescWithMap(){
        return names.stream()
                .map(name -> name.length())
                .sorted((name1, name2) -> name2.compareTo(name1))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        SortingAPI sortingAPI = new SortingAPI();
        System.out.println(sortingAPI.names);
        System.out.println(sortingAPI.sortByNameAsc());
        System.out.println(sortingAPI.sortByLengthDesc());
        System.out.println(sortingAPI.sortByLengthDescWithMap());

    }

}
