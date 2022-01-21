import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joe
 * edited by: Mihaela B C00242687
 *  date: 1/11/2021
 *  license: GNU General Public License v2.0
 */
public class Main {
    static final int MAX_T = 8;
    public static void main(String[] args){
        /**IntegerObj total= new IntegerObj(0);*/
        // creates five tasks
        Runnable r1 = new Leader("A",total);
        Runnable r2 = new Leader("B",total);
        Runnable r3 = new Leader("C",total);
        Runnable r4 = new Leader("D",total);
        Runnable r5 = new Follower("1",total);
        Runnable r6 = new Follower("2",total);
        Runnable r7 = new Follower("3",total);
        Runnable r8 = new Follower("4",total);

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        pool.execute(r6);
        pool.execute(r7);
        pool.execute(r8);

        // pool shutdown ( Step 4)
        pool.shutdown();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("total is: "+total.value);
    }
}