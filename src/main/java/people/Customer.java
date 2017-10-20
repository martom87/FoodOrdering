package people;

import java.util.Scanner;

public class Customer {
    Scanner sc;

    public Customer(Scanner sc) {
        this.sc = sc;
    }

    // TODO handle the input exception here
    public int doSomething() {
        sc = new Scanner(System.in);
        int casenumb = sc.nextInt();

        return casenumb;
    }
}
