package Controller;

import java.util.PriorityQueue;

import Model.Toy;
import View.Menu;

public class ControllerClass {
    
    public static void runApp() {
        Menu menuGen = new Menu();
        PriorityQueue<Toy> listToys = new PriorityQueue<>((toy1, toy2) -> toy2.getWeight() - toy1.getWeight());
        boolean appRun = true;
        
        while(appRun)
        {
        menuGen.printGeneralMenu();
        int userChoice = menuGen.Choice(5);
        switch (userChoice) {
            case 1:
                
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
