package examples.ch3;

public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class Reader implements Runnable {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Thread(new Reader()).start();

        number = 42;
        ready = true;
    }
}
