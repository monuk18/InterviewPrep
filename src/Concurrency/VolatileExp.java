package Concurrency;

public class VolatileExp {
    private int years;
    private int months;
    private volatile int days;

    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    public void update(int years, int months, int days){
        this.years  = years;
        this.months = months;
        this.days   = days;
    }

    public  static void main(String args[]){

        VolatileExp vObj =  new VolatileExp();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println( vObj.totalDays());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=1;
                while(i<11)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    vObj.update(2018,i,1);
                    i++;
                }
            }
        });


        t2.start();
        t1.start();


        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
