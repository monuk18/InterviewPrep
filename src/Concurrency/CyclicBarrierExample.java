package Concurrency;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    public static void  main(String args []){
        CyclicBarrier barrier = new CyclicBarrier(2,() -> {
            System.out.println("All workers arrived ");
        });
        Thread t1 = new Thread(new WorkerBarrier(barrier,1000));
        Thread t2 = new Thread(new WorkerBarrier(barrier,2000));
        t1.start();
        t2.start();
    }
}


class WorkerBarrier implements Runnable {
    private final CyclicBarrier latch;
    private final int wait;

    WorkerBarrier(CyclicBarrier latch, int wait) {
        this.latch = latch;
        this.wait = wait;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() +"Waiting ");
            Thread.sleep(wait);
            latch.await();
            System.out.println(Thread.currentThread().getName() +"Waiting over ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

