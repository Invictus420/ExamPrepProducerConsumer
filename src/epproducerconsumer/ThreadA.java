/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epproducerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class ThreadA implements Runnable{

    private ArrayBlockingQueue<Long> bq = new ArrayBlockingQueue(100);
    private ArrayBlockingQueue<Long> abq = new ArrayBlockingQueue(100);
    
    private long fib(long n) {
    if ((n == 0) || (n == 1)) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }

    public ThreadA(ArrayBlockingQueue<Long> bq, ArrayBlockingQueue<Long> a) {
        this.bq = bq;
        this.abq = a;
    }
    
    @Override
    public void run() {
          
            Long l;
            while((l = bq.poll()) != null){
            Long calc = fib(l);
            try { 
            abq.put(calc);
            System.out.println(l + ": " + calc);
             } catch (InterruptedException ex) {
            Logger.getLogger(ThreadA.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
       
    }
    
}
