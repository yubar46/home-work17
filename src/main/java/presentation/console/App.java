package presentation.console;

public class App {
    public static void main(String[] args) {
        Menu menu = new FirstMenu();


        do {
            menu =  menu.action();
        }while (menu!=null);

    }

}
