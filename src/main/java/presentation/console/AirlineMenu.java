package presentation.console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirlineMenu implements Menu {

    @Override
    public Menu action() {
        int choice;
        boolean trueChoice = false;
        do {
            System.out.printf("%s%n%s%n%s%n", "1- login", "2- sign up", "3-exit");
            Scanner console = new Scanner(System.in);
         try {
             choice = console.nextInt();
         }catch (InputMismatchException exception){
             System.out.println("enter correct number");
             return new AirlineMenu();


         }

            if (choice == 1 || choice == 2 || choice == 3) trueChoice = true;
            else System.out.println("wrong number entered");
        } while (!trueChoice);

        switch (choice) {
            case 1:
                return new LoginMenu();
            case 2:
                return new SignUpMenu();
            case 3:
                System.exit(0);
        }
        return new AirlineInsideMenu();
    }
}
