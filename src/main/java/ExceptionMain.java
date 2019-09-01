import model.ChoiceException;
import model.SaldoException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        double saldo = random.nextInt(100001);
        String choice = new String();
        while (!choice.toUpperCase().equals("Q")) {
            try {
                System.out.println("(0)-sprawdź saldo");
                System.out.println("(1)-wpłać kwotę w PLN");
                System.out.println("(2)-wypłać kwotę w PLN");
                System.out.println("(Q)-wyjdź");
                choice = scanner.nextLine();
                switch (choice) {
                    case "0":
                        System.out.printf("Stan konta: %.2f PLN\n", saldo);
                        break;
                    case "1":
                    case "2":
                        System.out.println("Wprowadź kwotę w PLN lub cofnij do menu (0)");
                        double amount = scanner.nextDouble();
                        System.out.println("Amount: " + amount);
                        // pelecenie 'konsumujące' zank enter -> \n
                        scanner.nextLine();
                        if (choice.equals("1") && amount != 0) {
                            saldo += amount;
                            System.out.printf("Konto zasilone kwotą %.2f PLN \n", amount);
                        } else if (choice.equals("2") && amount != 0) {
                            if (saldo < amount) {
                                throw new SaldoException();
                            }
                            saldo -= amount;
                            System.out.printf("Konto obciążone kwotą %.2f PLN \n", amount);

                        } else {
                            System.out.println("Powrót do menu");
                        }
                        break;
                    case "Q":
                    case "q":
                        System.out.println("Wyjście");
                        break;
                    default:
                        // wyrzucenie wyjątku choice exception
                        throw new ChoiceException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch");
//                e.printStackTrace();
                    scanner.nextLine();
            } catch (ChoiceException e) {

            } catch (SaldoException e) {
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
