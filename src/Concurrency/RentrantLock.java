package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLock {
	
	private static volatile  int count =0;
	private static Lock lock =  new ReentrantLock();
	
	  void increment(){
		 
		while(count<500)
		 {	lock.lock();
			count++;//this has to be in try catch , otherwise in case of exception it will be locked
			 System.out.println(Thread.currentThread().getName() +" ->"+ count );
			lock.unlock();
		 }
	}
	
	 public static void main(String[] args){

		 RentrantLock lockObj = new RentrantLock();

		Thread t1 = new  Thread(new Runnable() {
			@Override
			public void run() {
				lockObj.increment();
			}
		});
		Thread t2 = new  Thread(new Runnable() {
			@Override
			public void run() {
				lockObj.increment();
			}
		});

		t1.setName("T1");
		t2.setName("T2");
		t1.start();
		t2.start();

		
		/*try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		
		System.out.println(count);
	}
	
}
