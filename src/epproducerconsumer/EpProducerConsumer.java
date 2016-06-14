/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epproducerconsumer;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Alex
 */
public class EpProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        long[] list = {1L,2L,3L,4L, 5L,6L,7L, 8L,9L,10L,11L, 12L,13L,14L,15L,16L,17L,18L,19L,20L, 21L, 22L,23L,24L,25L,26L,27L,28L,29L,30L,31L,32L,33L, 34L, 35L,36L,37L,38L,39L,40L,41L,42L,43L,44L,45L};
        
        
        getT(list, 8);
        getT(list, 7);
        getT(list, 6);
        getT(list, 5);
        getT(list, 4);
        getT(list, 3);
        getT(list, 2);
        getT(list, 1);
        
//        ArrayBlockingQueue<Long> bq = new ArrayBlockingQueue(20);
//        for (long m : list) {
//            bq.add(m);
//        }
//        ArrayBlockingQueue<Long> abq = new ArrayBlockingQueue(20);
//        
//        Thread producer = new Thread(new ThreadA(bq, abq));
//        Thread producer2 = new Thread(new ThreadA(bq, abq));
//        Thread producer3 = new Thread(new ThreadA(bq, abq));
//        Thread producer4 = new Thread(new ThreadA(bq, abq));
//        ThreadB consumer = new ThreadB(abq);
//        
//        producer.start();
//        producer2.start();
//        producer3.start();
//        producer4.start();
//        consumer.start();
//        producer.join();
//        producer2.join();
//        producer3.join();
//        producer4.join();
//        consumer.setRun(Boolean.FALSE);
//        System.out.println("sum: " +consumer.getSum());
    }
    
    public static void getT(long[] list, int a) throws InterruptedException{
        long start = System.nanoTime()/1000000000;
        ArrayBlockingQueue<Long> bq = new ArrayBlockingQueue(100);
        ArrayList<Thread> list2 = new ArrayList();
        for (long m : list) {
            bq.add(m);
        }
        ArrayBlockingQueue<Long> abq = new ArrayBlockingQueue(100);
        
        for (int i = 0; i < a; i++) {
            list2.add(new Thread(new ThreadA(bq, abq)));
            list2.get(i).start();
        }
        ThreadB consumer = new ThreadB(abq);
        consumer.start();
        
        for (int i = 0; i < a; i++) {
            list2.get(i).join();
        }
        
        consumer.setRun(false);
        long end = System.nanoTime()/1000000000;
        System.out.println("Sum: " + consumer.getSum());
        System.out.println("Time: " + (end-start));
    }
    
}
