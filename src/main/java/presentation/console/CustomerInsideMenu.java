package presentation.console;

import context.ApplicationContext;
import domain.Travel;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CustomerInsideMenu implements Menu {
  List<Travel> flies;

  @Override
  public Menu action() {
    Scanner console = new Scanner(System.in);
    System.out.println("enter source city");
    String source = console.next();
    System.out.println("enter destination city");
    String destination = console.next();
    System.out.println("enter date of fly");
    System.out.println("day:");
    int day;
    try {
      day = console.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("enter correct number");
      return new CustomerInsideMenu();
    }

    System.out.println("month:");
    int month;
    try {
      month = console.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("enter correct number");
      return new CustomerInsideMenu();
    }
    System.out.println("year:");
    int year;
    try {
      year = console.nextInt();
    } catch (InputMismatchException exception) {
      System.out.println("enter correct number");
      return new CustomerInsideMenu();
    }
    LocalDate date = LocalDate.now();
    try {
      date = LocalDate.of(year, month, day);
    } catch (DateTimeException exception) {
      System.out.println("enter correct date");
    }

    if (!ApplicationContext.getInstance().getTravelService()
      .findByDateAndCity(date, source, destination).isEmpty()) {
      flies = ApplicationContext.getInstance().getTravelService()
        .findByDateAndCity(date, source, destination);
      flies.forEach(System.out::println);
      sorting(flies);
      return new CustomerInsideMenu();
    } else System.out.println("there is no fly with this parameters");


    return new CustomerInsideMenu();
  }

  private void sorting(List<Travel> flies) {
    Scanner console = new Scanner(System.in);

    do {
      System.out.println("1- sort by ticket cost");
      System.out.println("2- sort by airline name ");
      System.out.println("3- sort by source city ");
      System.out.println("4- sort by destination city");
      System.out.println("5- exit");
      int choice = 0;
      try {
        choice = console.nextInt();
      } catch (InputMismatchException exception) {
        System.out.println("enter correct number");
        sorting(flies);
      }
      switch (choice) {
        case 1:
          flies.sort(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
              return o1.compareToFlyCost(o2);
            }
          });
          break;
        case 2:
          flies.sort(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
              return o1.compareToAirlineCompany(o2);
            }
          });
          break;
        case 3:
          flies.sort(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
              return o1.compareToSourceCity(o2);
            }
          });
          break;
        case 4:
          flies.sort(new Comparator<Travel>() {
            @Override
            public int compare(Travel o1, Travel o2) {
              return o1.compareToDesCity(o2);
            }
          });
          break;
        case 5:System.exit(0);


      }

      System.out.printf("%s%n%s%n", "1-Ascending sort", "2-Descending sort");
      int select = console.nextInt();

      if (select == 1) {
        flies.forEach(System.out::println);
      }
      if (select == 2) {
        for (int i = flies.size() - 1; i >= 0; i--) {
          System.out.println(flies.get(i));
        }
      } else {
        System.out.println("enter right number");
        sorting(flies);
      }

    } while (true);
  }

}
