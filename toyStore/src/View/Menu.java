package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public void printGeneralMenu()
    {
        System.out.println("Приложение 'Магазин игрушек'");
        System.out.println("Меню:");
        System.out.println("1. Запустить розыгрыш");
        System.out.println("2. Добавить игрушку ");
        System.out.println("3. Просмотреть очередь ");
        System.out.println("4. Изменить вес игрушки");
        System.out.println("5. Выйти ");
        System.out.println("Введите номер пункта: ");
    }

    public int Choice(int max_value) {
    Scanner scan = new Scanner(System.in);
    boolean flag = false;

    while (!flag) {
        try {
            int userChoice = scan.nextInt();
            scan.nextLine(); 
            if (userChoice <= max_value && userChoice > 0) {
                flag = true;
                return userChoice;
            } else {
                throw new IllegalArgumentException("Недопустимый выбор. Введите число от 1 до " + max_value);
            }
        } catch (InputMismatchException e) {
            scan.next(); 
            System.out.println("Введите корректное число.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    return max_value;
}

}