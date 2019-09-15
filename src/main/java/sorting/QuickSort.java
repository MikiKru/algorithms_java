package sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    void qsort(List<Integer> numbers) {
        qs(numbers, 0, numbers.size() - 1);
    }
    private void qs(List<Integer> numbers, int left, int right) {
        int i, j;
        int x, y;
        i = left;
        j = right;
        x = numbers.get((left + right) / 2); // element podziału
        do {
            while ((numbers.get(i) < x) && (i < right)) i++;
            while ((x < numbers.get(j)) && (j > left)) j--;
            if (i <= j) {
                y = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, y);
                i++;
                j--;
            }
        } while (i <= j);
        if (left < j) qs(numbers, left, j);
        if (i < right) qs(numbers, i, right);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,3,2,1));
        new QuickSort().qsort(numbers);
        System.out.println(numbers);
    }
}
