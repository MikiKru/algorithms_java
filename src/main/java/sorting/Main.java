package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    HeapSort heapSort = new HeapSort();
    BubbleSort bubbleSort = new BubbleSort();
    QuickSort quickSort = new QuickSort();

    List<Integer> list_10 = new ArrayList<>();
    List<Integer> list_100 = new ArrayList<>();
    List<Integer> list_1000 = new ArrayList<>();

    // metoda generująca n losowych wartości
    private void generateNValues(int n, List<Integer> list){
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(1000));
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.generateNValues(10, main.list_10);
        main.generateNValues(100, main.list_100);
        main.generateNValues(1000, main.list_1000);


    }

}
