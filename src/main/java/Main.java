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

        int a1 = 2;
        int q = 3;
        n = 4;
        Map<String,Double> geoSeriesMap = ac.geoSeries(a1,q,n);
        System.out.printf("Suma %d-elemetów: %f i %d-ty element: %f\n",
                n, geoSeriesMap.get("sum"),n, geoSeriesMap.get("element"));

        a1 = 2;
        int r = 3;
        n = 4;
        int [] results = ac.arithSeries(a1,r,n);
        System.out.printf("Suma %d-elemetów: %d i %d-ty element: %d\n",
                n, results[0],n, results[1]);

    }
}
