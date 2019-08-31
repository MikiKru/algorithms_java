package controller;

import java.util.HashMap;
import java.util.Map;

// klasa implementująca rozwiązania
public class AlgorithmsController {
    public int power(int x, int y){
        int result = 1;
        for(int i = 1; i <= y; i++){
//            result = result * x;
            result *= x;
        }
        return result;
    }
    public int factorial(int n){
        int result = 1;
        while(n > 1){
            result *= n;
            n--;
        }
        return result;
    }
    public Map<String,Double> geoSeries(int a1, int q, int n){
        Map<String, Double> geoSeriesMap = new HashMap<>();
        double sum = 0;
        for(int i = 1; i <= n; i++){
            sum += a1*power(q,i-1);
            System.out.println(sum);
        }
        // przekazujemy do mapy sumę ciągu
        geoSeriesMap.put("sum", sum);
        // przekazujemy do mapy wartość ostatniego elementu ciągu
        geoSeriesMap.put("element", (double) (a1*power(q,n-1)));
        // zwacamy mapę wartości
        return geoSeriesMap;
    }

}
