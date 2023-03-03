public class SomeController {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> Runner.addCounter()).start();
        }
        System.out.println(Runner.getCounter());
    }
}


class Runner {
    private static int counter = 0;


    public static void addCounter() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}

