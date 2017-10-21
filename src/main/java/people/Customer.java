package people;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {
    Scanner sc;


    public Customer(Scanner sc) {
        this.sc = sc;
    }


    public int saySomething() {
        boolean inputError = true;
        int userInput = 0;
        while (inputError) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                inputError = false;
            }
            try {

                userInput = sc.nextInt();
            } catch (InputMismatchException wrongData) {
                System.out.println("ONLY INTEGER NUMBERS CAN BE TYPED");
                System.out.println("Please type again :)");
            }
        }
        return userInput;
    }

    public int saySomething2() {
        boolean inputError = true;
        int userInput2 = 0;
        while (inputError) {
            Scanner sc2 = new Scanner(System.in);
            if (sc.hasNextInt()) {
                inputError = false;
            }
            try {

                userInput2 = sc2.nextInt();
            } catch (InputMismatchException wrongData) {
                System.out.println("ONLY INTEGER NUMBERS CAN BE TYPED");
                System.out.println("Please type again :)");
            }
        }
        return userInput2;
    }


}

