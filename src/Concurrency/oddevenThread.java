package Concurrency;

public class oddevenThread {

    static int MAX_VALUE=10;
    public static int num = 1;

    void printEvenNum(){
       while (num <MAX_VALUE)
       {
           synchronized (this) {
               System.out.println("while printEVEN");
               if (num % 2 == 0)
                   System.out.println(num);
               num++;
               System.out.println("while printEVEN calling notify");
               this.notify();
               System.out.println("while printEVEN  notify called");
               try {
                   System.out.println("while printEVEN calling wait");
                   this.wait();
                   System.out.println("while printEVEN   wait  called");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
       }
       synchronized (this){
           System.out.println("while printEVEN   LAsT NOTIFY  called");
           this.notify();
       }

    }

    void printOddNum(){
        while (num <MAX_VALUE){
            synchronized (this) {
                System.out.println("while printOddNum");
                if (num % 2 != 0)
                    System.out.println(num);
                num++;
                System.out.println("while printOddNum calling notify");
                this.notify();
                System.out.println("while printOddNum  notify called");
                try {
                    System.out.println("while printOddNum calling wait");
                    this.wait();
                    System.out.println("while printOddNum   wait  called");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public static  void  main(String [] args){

        oddevenThread obj =new oddevenThread();

        Thread tOdd = new  Thread(new Runnable() {
            @Override
            public void run() {
                obj.printOddNum();
            }
        });
        Thread tEven = new  Thread(new Runnable() {
            @Override
            public void run() {
                obj.printEvenNum();
            }
        });

        tOdd.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tEven.start();
    }
}
