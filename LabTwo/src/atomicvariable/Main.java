/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomicvariable;
import java.text.SimpleDateFormat; 
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joe
 *  edited by: Mihaela Brodetchi C00242687
 *  date: 11/10/2021
 *  license: GNU General Public License v2.0
 */
public class Main {
    
      // Maximum number of threads in thread pool
    static final int MAX_T = 4;             
  
    public static void main(String[] args)
    {
        IntegerObj total= new IntegerObj(new AtomicInteger());
        // creates five tasks
        Runnable r1 = new Task("task 1",total);
        Runnable r2 = new Task("task 2",total);
        Runnable r3 = new Task("task 3",total);
        Runnable r4 = new Task("task 4",total);    
          
        // creates a thread pool with MAX_T no. of 
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);  
         
        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
          
        // pool shutdown ( Step 4)
        pool.shutdown();    
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("total is: "+total.value);
    }
}