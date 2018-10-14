package Concurrency.ThreadPool;


public class Main {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(7,9);

        for (int i = 0; i < 15; i++) {
            Task task = new Task(i);
            try {
                pool.execute(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
          pool.stop();

    }

}