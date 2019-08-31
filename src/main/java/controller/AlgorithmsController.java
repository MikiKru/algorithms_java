package controller;
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
}
