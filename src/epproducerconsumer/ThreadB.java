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
public class ThreadB extends Thread{
    
    private ArrayBlockingQueue<Long> abq = new ArrayBlockingQueue(100);
    private Long sum = 0L;
    private Boolean run = true;
    
    public ThreadB(ArrayBlockingQueue abq) {
        this.abq = abq;
    }

    public void setRun(Boolean run) {
        this.run = run;
    }

    public Long getSum() {
        return sum;
    }
    
    @Override
    public void run(){
        while(run){
        if(!abq.isEmpty()){
            try {
                sum = sum + abq.take();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
           
        }
        
    }
    
}
