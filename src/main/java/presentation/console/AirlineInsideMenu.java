package presentation.console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirlineInsideMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        int choice;
        boolean check = false;
        do {
            System.out.printf("%s%n%s%n%s%n", "1- add new fly", "2- delete fly",
                    "3-exit");
            try {
                choice = console.nextInt();
            }catch (InputMismatchException exception){
                System.out.println("enter correct number");
                return new AirlineInsideMenu();


            }
            if (choice == 1 || choice == 2 || choice == 3 ) check = true;
        } while (!check);

        switch (choice) {
            case 1:
                return new AddnewFlyMenu();
            case 2:
                return new AirlineInsideMenu();
            case 3:
              System.exit(0);
        }

        return null;

    }
}
