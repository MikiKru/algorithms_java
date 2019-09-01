package model;

public class SaldoException extends Exception {
    public SaldoException() {
        System.out.println("Saldo nie może być ujemne!");
    }
}
