package sorting;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
    public List<Integer> bsort(List<Integer> numbers) {
        // iterowanie po próbach sortowania
        for (int i = 0; i < numbers.size() - 1; i++) {
            // iterowanie po elementach listy
            for (int j = 0; j < numbers.size() - 1; j++) {
                // porównanie sąsiednich elementów
                if (numbers.get(j) < numbers.get(j + 1)) {
                    // do zmiennej pomocniczej przekazuję element o indeksie j
                    int tmp = numbers.get(j);
                    // wartość mniejsza nadpisuje wartość na indeksie j
                    numbers.set(j, numbers.get(j + 1));
                    // wartość większa nadpisuje wartość na indeksie j + 1
                    numbers.set(j + 1, tmp);
                }
            }
            System.out.println("etap: " + i + " wynik: " + numbers);
        }
        return numbers;
    }

    public List<Integer> bsortWithTypes(List<Integer> numbers, String type) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - 1; j++) {
                if (type.toUpperCase().equals("ASC") ? numbers.get(j) > numbers.get(j + 1) : numbers.get(j) < numbers.get(j + 1)) {
                    int tmp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, tmp);
                }
            }
            System.out.println(numbers);
        }
        return numbers;
    }
    public List<Integer> bsortDynamicWithTypes(List<Integer> numbers, String type) {
        boolean isUnsorted = true;
        for (int i = 0; isUnsorted; i++) {
            // licznik wejść do if-a
            int counter = 0;
            for (int j = 0; j < numbers.size() - 1; j++) {
                if (type.toUpperCase().equals("ASC") ? numbers.get(j) > numbers.get(j + 1) : numbers.get(j) < numbers.get(j + 1)) {
                    int tmp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, tmp);
                    // inkrementacja licznika
                    counter++;
                }
            }
            // sprawdzamy stan licznika
            if(counter == 0){
                isUnsorted = false;
            } else {
                System.out.println(numbers);
            }
        }
        return numbers;
    }
    public long getTimeInterval(List<Integer> list){
        long start = System.currentTimeMillis();
        bsort(list);
        long stop = System.currentTimeMillis();
        return stop - start;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bsort(new ArrayList<>(Arrays.asList(3, 2, 4, 15, 3, 1, 3, 2, 1, 6, 9)))
                .stream().forEach(number -> System.out.print(number + " "));
        System.out.println();
        bubbleSort.bsortWithTypes(new ArrayList<>(Arrays.asList(3, 2, 4, 15, 3, 1, 3, 2, 1, 6, 9)),"asc")
                .stream().forEach(number -> System.out.print(number + " "));
        System.out.println();
        bubbleSort.bsortWithTypes(new ArrayList<>(Arrays.asList(1,2,3,4,5,7,6,8,10)),"asc")
                .stream().forEach(number -> System.out.print(number + " "));
        System.out.println();
        bubbleSort.bsortDynamicWithTypes(new ArrayList<>(Arrays.asList(1,2,3,4,5,7,6,8,10)),"asc")
                .stream().forEach(number -> System.out.print(number + " "));






    }
}
