import controller.AlgorithmsController;

import java.time.Duration;
import java.time.LocalTime;
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
        int number = 6;
        System.out.printf("Dzielniki liczby %d to: %s\n",
                number, ac.getDividers(number).toString());
        System.out.println(
                "Liczba "+ number + " " + (ac.isExcellent(number)?
                        "jest doskonała" : "nie jest doskonała")
        );
        int num1 = 55;
        int num2 = 11;
        System.out.printf("NWD dla liczv %d i %d wynosi: %d\n",
                num1, num2, ac.getNWD(num1,num2));

        System.out.println(ac.isPrimeNumber(15));
        System.out.println(ac.isPrimeNumber(13));
        // pomiar czasu
        LocalTime t_start = LocalTime.now();
        ac.generatePrimeNumbers(100);
        LocalTime t_stop = LocalTime.now();
        Long time_interval = Duration.between(t_start,t_stop).toMillis();
        System.out.println("Czas wykonania programu: "+time_interval+" ms");

        System.out.println(ac.binToDec("100"));
        System.out.println(ac.binToDec("1001"));

//        int i = 2;
//        int j = 3;
//        System.out.println(j/i);
//        System.out.println((double)j/i);
//        System.out.println((double)(j/i));
        System.out.println("XXXXX");
        System.out.println(ac.decToBin(8));

        System.out.println(ac.getTempAvg(0.1,-10,10,10));

    }
}
