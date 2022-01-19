/**
 * @author Joseph Kehoe
 * @edited by: Mihaela Brodetchi C00242687
 * date: 19/10/2021
 * license: GNU General Public License v2.0
 */

//This shows a reusable barrier in action, utilising only semaphores
//The loop gives it the reusable functionality.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static final int MAX_T = 4;

    public static void main(String[] args) {

        Runnable r1 = new Barrier("task 1",MAX_T);
        Runnable r2 = new Barrier("task 2",MAX_T);
        Runnable r3 = new Barrier("task 3",MAX_T);
        Runnable r4 = new Barrier("task 4",MAX_T);

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
    }
}
