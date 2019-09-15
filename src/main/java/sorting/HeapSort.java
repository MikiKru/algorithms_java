package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort
{
    public void sort(List<Integer> numbers) {
        int n = numbers.size();
        // budowanie kopca
        for (int j = n / 2 - 1; j >= 0; j--) {
            heapify(numbers, n, j);
        }
        // wydobywanie po jednym elemencie z kopca
        for (int j = n-1; j >= 0; j--) {
            int temp = numbers.get(0);
            numbers.set(0, numbers.get(j));
            numbers.set(j, temp);
            // redukcja kopca
            heapify(numbers, j, 0);
        }
    }
    void heapify(List<Integer> numbers, int n, int i) {
        int largest = i; // przyjmujemy, że największa wartość jest korzeniem indeks 0
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        // jeżeli lewy jest większy niż korzeń
        if (l < n && numbers.get(l) > numbers.get(largest))
            largest = l;
        // jeżeli prawy jest większy niż korzeń
        if (r < n && numbers.get(r) > numbers.get(largest))
            largest = r;
            // jeżeli największy nie był korzeniem
        if (largest != i) {
            int swap = numbers.get(i);
            numbers.set(i, numbers.get(largest));
            numbers.set(largest, swap);
            // rekursywne redukowanie kopca
            heapify(numbers, n, largest);
        }
    }
    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(4,2,5,5));
        HeapSort heapSort = new HeapSort();
        heapSort.sort(numbers);
        System.out.println(numbers);
    }
}
