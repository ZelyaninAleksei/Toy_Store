package Model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Toy {
    int id;
    String nameToy;
    int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameToy() {
        return nameToy;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static Toy createNewToy() {
        Toy toy = new Toy();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Введите наименование (название): ");
            toy.setNameToy(sc.nextLine());

            boolean validWeight = false;
            while (!validWeight) {
                try {
                    System.out.print("Установите вес (частоту выпадения): ");
                    toy.setWeight(sc.nextInt());
                    validWeight = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректный вес (целое число).");
                    sc.nextLine();
                }
            }

            boolean validId = false;
            while (!validId) {
                try {
                    System.out.print("Введите ID: ");
                    toy.setId(sc.nextInt());
                    validId = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректный ID (целое число).");
                    sc.nextLine();
                }
            }
        
        
        return toy;
    }
    finally {

    }
}

    @Override
    public String toString(){
        return "\n ID: "+getId() + "\n Наименование: " + getNameToy() + "\n Вес: " + getWeight(); 
    }
}
