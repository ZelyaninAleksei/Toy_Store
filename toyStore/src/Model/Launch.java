package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Класс содержащий метод,
 * выполняющий основную логику розыгрыша.
 */
public class Launch {
    /**
     * @param listToys - список игрушек
     * @throws IOException - обработка ошибки и вывод трассировки стека ошибки.
     */
    public static void launchRun(PriorityQueue<Toy> listToys) throws IOException {
        FileWriter writer = new FileWriter("results.txt",  true);
        try {
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                int randomValue = random.nextInt(10); // Генерируем случайное число от 0 до 9

                Toy selectedToy;
                if (randomValue < 2) { // 20% вероятность
                    selectedToy = selectToyWithWeight(listToys, 2);
                } else if (randomValue < 4) { // 20% вероятность
                    selectedToy = selectToyWithWeight(listToys, 3);
                } else { // 60% вероятность
                    selectedToy = selectToyWithWeight(listToys, 1);
                }

                if (selectedToy != null) {
                    writer.write("Get: " + selectedToy.id + " - " + selectedToy.getNameToy() + "\n");
                    listToys.add(selectedToy); // Помещаем игрушку обратно в очередь
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param toyQueue - очередь игрушек
     * @param weight   - вес (частота выпадения) игрушки
     * @return - возвращает toy если игрушка с указанным весом есть в очереди,
     * возвращает null - для обозначения того, что игрушка с таким весом не была найдена.
     */
    private static Toy selectToyWithWeight(PriorityQueue<Toy> toyQueue, int weight) {
        for (Toy toy : toyQueue) {
            if (toy.weight == weight) {
                toyQueue.remove(toy);
                return toy;
            }
        }
        return null;
    }
}