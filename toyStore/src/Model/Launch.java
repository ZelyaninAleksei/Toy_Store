package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class Launch {
    public static void launchRun(PriorityQueue<Toy> listToys) throws IOException {
        FileWriter writer = new FileWriter("results.txt", true);
        try {
            Random random = new Random(11);
            int randomValue = random.nextInt();

            Iterator<Toy> iterator = listToys.iterator();
            while (iterator.hasNext()) {
                Toy toy = iterator.next();
                int quant = toy.getQuantity() - 1;
                int weightToy = toy.getWeight();
                if (randomValue <= 2 && weightToy <= 2) {
                    System.out.println("Розыгрыш проведён. \n" + "результат:" + toy.getNameToy());
                    writer.write("Идентификатор игрушки: " + toy.getId() + " - " + toy.getNameToy() + " Остаток: " + quant + "\n");
                    toy.setQuantity(quant);
                    if (quant == 0) iterator.remove();
                    break;
                } else if ((randomValue > 2 && randomValue <= 4) && (weightToy > 2 && weightToy <= 4)) {
                    System.out.println("Розыгрыш проведён. \n" + "результат:" + toy.getNameToy());
                    writer.write("Идентификатор игрушки: " + toy.getId() + " - " + toy.getNameToy() + " Остаток: " + quant + "\n");
                    toy.setQuantity(quant);
                    if (quant == 0) iterator.remove();
                    break;
                } else {
                    System.out.println("Розыгрыш проведён. \n" + "результат:" + toy.getNameToy());
                    writer.write("Идентификатор игрушки: " + toy.getId() + " - " + toy.getNameToy() + " Остаток: " + quant + "\n");
                    toy.setQuantity(quant);
                    if (quant == 0) iterator.remove();
                    break;
                }
            }
        } catch (Exception ignored) {

        }
        writer.close();
    }
}
