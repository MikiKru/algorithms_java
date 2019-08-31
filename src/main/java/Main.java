import controller.AlgorithmsController;

import java.util.*;
// klasa uruchamiająca projekt
public class Main {
    public static void main(String[] args) {
        AlgorithmsController ac =
                new AlgorithmsController();
        int x = 2;
        int y = 0;
        System.out.printf("%d ^ %d = %d\n",x, y, ac.power(x,y));
        int n = 4;
        System.out.printf("%d! = %d\n", n, ac.factorial(n));
    }
}
