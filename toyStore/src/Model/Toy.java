package Model;

import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Toy {
    int id;
    String nameToy;
    int weight;
    int quantity;

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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
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
            boolean validQuantity = false;
            while (!validQuantity) {
                try {
                    System.out.println("Введите количество: ");
                    toy.setQuantity(sc.nextInt());
                    validQuantity = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректное количество (целое число).");
                    sc.nextLine();
                }
            }

            return toy;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeWeight(Toy toy) {
        boolean validNewWeight = false;
        while (!validNewWeight) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("Введите новый вес: ");
                int newWeight = sc.nextInt();
                toy.setWeight(newWeight);
                validNewWeight = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректный вес (целое число).");
                sc.nextLine();
            }
        }
    }

    public static Toy choosingToy(PriorityQueue<Toy> listToys) {
        Scanner sc = new Scanner(System.in);

        for (Toy toy : listToys) {
            System.out.println(toy);
        }

        boolean validID = false;
        int lastToyID = -1; // Переменная для хранения ID последней игрушки

        while (!validID) {
            try {
                System.out.println("Введите ID нужной игрушки: ");
                int id = sc.nextInt();

                for (Toy toy : listToys) {
                    if (toy.id == id) {
                        lastToyID = id;
                        validID = true;
                        return toy;
                    }
                }

                System.out.println("Ошибка: Игрушка с таким ID не найдена.");
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректный ID (целое число).");
                sc.nextLine();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "\n ID: " + getId() + " Наименование: " + getNameToy() +
                "\n Вес: " + getWeight() + " Количество: " + getQuantity();
    }

}
