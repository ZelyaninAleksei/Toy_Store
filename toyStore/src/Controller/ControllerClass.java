package Controller;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

import Model.Launch;
import Model.Toy;
import View.Menu;

public class ControllerClass {
    
    public static void runApp() throws IOException {
        Menu menuGen = new Menu();
        PriorityQueue<Toy> listToys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight));
        boolean appRun = true;
        
        while(appRun)
        {
        menuGen.printGeneralMenu();
        int userChoice = menuGen.Choice(5);
        switch (userChoice) {
            case 1:
                Launch.launchRun(listToys);
                break;
            
            case 2:
                listToys.add(Toy.createNewToy());
                break;
            case 3:
                for (Toy toy : listToys) {
                    System.out.println(toy);
                }
                break;            
            case 4:
                
                break;
            case 5:
                appRun = false;
                break;
            
            default:
                break;
        }

    }
    
}
}
