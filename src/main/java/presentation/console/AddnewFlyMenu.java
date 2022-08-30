package presentation.console;

import context.ApplicationContext;
import domain.Travel;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddnewFlyMenu implements Menu {
  @Override
  public Menu action() {
    Scanner console = new Scanner(System.in);
    System.out.println("enter source city");
    String sourceCity = console.next();
    System.out.println("enter destination city");
    String destinationCity = console.next();
    System.out.println("enter ticket cost");
    Integer flyCost;
    try {
       flyCost = console.nextInt();
    }catch (InputMismatchException exception){
      System.out.println("enter correct number");
      return new AirlineInsideMenu();
    }

    System.out.println("enter airplane model");
    String airplaneModel = console.next();
    System.out.println("enter date of fly");
    System.out.println("day:");
    int day;
    try {
       day = console.nextInt();
    }catch (InputMismatchException exception){
      System.out.println("enter correct number");
      return new AirlineInsideMenu();
    }
    System.out.println("month:");
    int month;
    try {
       month = console.nextInt();
    }catch (InputMismatchException exception){
      System.out.println("enter correct number");
      return new AirlineInsideMenu();
    }
    System.out.println("year:");
    int year;
    try {
       year = console.nextInt();
    }catch (InputMismatchException exception){
      System.out.println("enter correct number");
      return new AirlineInsideMenu();
    }
    LocalDate localDate;
    try {
       localDate = LocalDate.of(year,month,day);
    }catch (DateTimeException exception){
      System.out.println("enter correct date time");
      return new AirlineInsideMenu();
    }
    System.out.println("enter time of fly");
    System.out.println("hour");
    int hour ;
    try {
      hour= console.nextInt();
    }catch (InputMismatchException exception){
      System.out.println("enter correct number");
      return new AirlineInsideMenu();
    }

    System.out.println("minute");
    int minute;
    try {
     minute = console.nextInt();
    }catch (InputMismatchException exception){
      System.out.println("enter correct number");
      return new AirlineInsideMenu();
    }



    LocalTime localTime;
    try {
       localTime =   LocalTime.of(hour,minute);
    }catch (DateTimeException exception){
      System.out.println("enter correct date time");
      return new AirlineInsideMenu();
    }


    Travel travel = new Travel(flyCost,airplaneModel,sourceCity,destinationCity,localTime,localDate);
    travel.setTravelCompany(ApplicationContext.getInstance().getTravelCompany());
    ApplicationContext.Instance.getTravelService().create(travel);
    return new AirlineInsideMenu();
  }
}
