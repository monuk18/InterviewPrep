package Concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void  main(String args []){
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(new Worker(latch,1000));
        Thread t2 = new Thread(new Worker(latch,2000));
        t1.start();
        t2.start();
        try {
            System.out.println(Thread.currentThread().getName() + "waiting ");
            latch.await();
            System.out.println(Thread.currentThread().getName() + "waiting Completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}


class Worker implements Runnable {
    private final CountDownLatch latch;
    private final int wait;

    Worker(CountDownLatch latch, int wait) {
        this.latch = latch;
        this.wait = wait;
    }

    @Override
    public void run() {
        /*try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(Thread.currentThread().getName());
        latch.countDown();
        System.out.println(Thread.currentThread().getName()+"counted Down");
    }
}

