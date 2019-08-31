package controller;

import java.util.*;

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
        }
        // przekazujemy do mapy sumę ciągu
        geoSeriesMap.put("sum", sum);
        // przekazujemy do mapy wartość ostatniego elementu ciągu
        geoSeriesMap.put("element", (double) (a1*power(q,n-1)));
        // zwacamy mapę wartości
        return geoSeriesMap;
    }
    public int[] arithSeries(int a1, int r, int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += a1 + power(r,i-1);
        }
        int [] results = {
                sum,
                a1 + power(r,n-1)
        };
        return results;
    }
    public List<Integer> getDividers(int number){
        List<Integer> dividers = new ArrayList<>();
        for(int i = number; i > 0; i--){
            if(number % i == 0){
                dividers.add(i);
            }
        }
        return dividers;
    }
    public boolean isExcellent(int number){
        int sum = 0;
        // lista dzielników
        List<Integer> dividers = getDividers(number);
        // usunięcie pierwszego elementu
        dividers.remove(0);
        // suma wszystkich elementów listy dzialników
        for(int divider : dividers){
            sum += divider;
        }
        // wyrażenie 3-argumentowe
        // (warunek) ? wartość jeżeli prawdziwy : wartość jeżeli fałszywy
        return sum == number;
    }
    public int getNWD(int num1, int num2){
        // sprawdzamy która liczba jest większa
        int max = num1;
        int min = num2;
        if(num1 < num2){
            max = num2;
            min = num1;
        }
        for(int divider : getDividers(min)){
            if(max % divider == 0){
                return divider;
            }
        }
        return 1;
    }
    public boolean isPrimeNumber(int n){
        return getDividers(n).size() == 2;
    }
    public List<Integer> generatePrimeNumbers(int n){
        List<Integer> elements = new ArrayList<>();
        int i = 3;
        do{
            // spr czy kolejna liczba naturalna jest pierwsza
            if(isPrimeNumber(i)){
                elements.add(i);
            }
            i++;
        }while(elements.size() < n);
        return elements;
    }
    public int binToDec(String bin){
        // manipulacja napisami - pozwala ingerować w napis
        StringBuilder sb = new StringBuilder(bin);
        // odwrócenie napisu
        bin = sb.reverse().toString();
        int dec = 0;
        for(int i = 0; i < bin.length(); i++){
            dec += Character.getNumericValue(bin.charAt(i)) * power(2, i);
        }
        return dec;
    }
    public String decToBin(int dec){
        String result = "";
        while(dec > 1){
            // do wyniku zapisujemy wynika działania modulo
            result += String.valueOf(dec % 2);
            // każdowazowo wykonujemy podział liczby
            dec = dec / 2;
        }
        result += "1";
        return new StringBuilder(result).reverse().toString();
    }
    public List<Integer> getRandomValues(int lowBound, int topBound, int n){
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i = 0; i < n; i++){
            randomNumbers.add(random.nextInt(topBound - lowBound + 1) + lowBound);
        }
        return randomNumbers;
    }
    public double getTempAvg(double support, int lowBound, int topBound, int n){
        List<Integer> randomNumbers = getRandomValues(lowBound, topBound, n);
        System.out.println(randomNumbers);
        double maxSupp = topBound - (support * (topBound - lowBound));
        double minSupp = lowBound + (support * (topBound - lowBound));
        System.out.println("MIN:" + minSupp);
        System.out.println("MAX:" + maxSupp);
        List<Integer> preparedValues = new ArrayList<>();
        int sum = 0;
        for(Integer number : randomNumbers){
            if(number < maxSupp && number > minSupp){
                preparedValues.add(number);
                sum += number;
            }
        }
        System.out.println(preparedValues);
        return sum / (double) preparedValues.size();
    }
}
