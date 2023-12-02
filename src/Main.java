import util.MenuManager;

public class Main {
    public static void main(String[] args) {

        MenuManager mm = new MenuManager();

        boolean canExecute = mm.showMenu();

        if(canExecute){
            mm.showDayResults();
        }

    }

}