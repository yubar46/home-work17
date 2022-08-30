package presentation.console;

import java.util.Scanner;

public class CustomerMenu implements Menu {
  @Override
  public Menu action() {
    Scanner console = new Scanner(System.in);
    System.out.println("1-buy ticket");
    System.out.println("2-search  ticket");
    System.out.println("3- exit");
    int select = console.nextInt();
    switch (select){
      case 1:return new BuyTicketMenu();
      case 2:return new CustomerInsideMenu();
      case 3:System.exit(0);
    }
    return new CustomerMenu();
  }
}
