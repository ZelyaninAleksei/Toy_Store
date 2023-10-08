    package Model;

    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.PriorityQueue;
    import java.util.Random;

    public class Launch {
        public static void launchRun(PriorityQueue<Toy> listToys) {
            try {
                FileWriter writer = new FileWriter("results.txt");
                Random random = new Random();

                for (int i = 0; i < 10; i++) {
                    int randomValue = random.nextInt(10); // Генерируем случайное число от 0 до 9
                    Toy toy = listToys.poll(); // Извлекаем игрушку с наименьшим весом
                    listToys.add(toy); // Помещаем её обратно в очередь

                    String result;
                    if (randomValue < 2) { // 20% вероятность
                        result = "Get: 1 - " + toy.getNameToy();
                    } else if (randomValue < 4) { // 20% вероятность
                        result = "Get: 2 - " + toy.getNameToy();
                    } else { // 60% вероятность
                        result = "Get: 3 - " + toy.getNameToy();
                    }

                    writer.write(result + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {

            }
        }
    }
