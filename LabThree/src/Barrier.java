/**
 * @author Mihaela Brodetchi C00242687
 * date: 19/10/2021
 * license: GNU General Public License v2.0
 */

//This shows a reusable barrier in action, utilising only semaphores
//The loop gives it the reusable functionality.

import java.util.concurrent.Semaphore;

public class Barrier implements Runnable {

    private int n;
    private int count;
    private String name;
    private Semaphore turnsTile = new Semaphore(1);
    private Semaphore turnsTile2 = new Semaphore(0);
    private Semaphore mutex = new Semaphore(1);

    public Barrier(String name, int threadAmt) {
        this.n = n;
        this.count = 0;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            mutex.acquire();
            count++;
            if (count == n) {
                turnsTile2.acquire(); //lock the second
                turnsTile.release(); // unlock the first
            }
            mutex.release();
            turnsTile.acquire(); //first turnstile
            turnsTile.release();

            // critical point

            for (int i = 0; i < 4; i++) {
                System.out.println(this.name + " is running.");
                Thread.sleep(2000);
            }

            mutex.acquire();
            count--;
            if (count == 0) {
                turnsTile.acquire(); //lock the first
                turnsTile2.release(); //unlock second
            }
            mutex.release();
            turnsTile2.acquire(); //second turnstile
            turnsTile2.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
