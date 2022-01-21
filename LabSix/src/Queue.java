import java.util.concurrent.Semaphore;
/**
 * @author Mihaela B C00242687
 *  date: 17/1/2022
 *  license: GNU General Public License v2.0
 *Create a Java project that shows a solution to the producers-consumers problem.
 * The solution must be implemented as one or more Java classes that utilises only semaphores.
 */

class Queue {
    int itemNumber;
    static Semaphore Producer = new Semaphore(1);
    static Semaphore Consumer = new Semaphore(0);
    //initialise Producer+Consumer semaphores

    void putToBuffer(int itemNumber) {
        try {
            Producer.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.itemNumber = itemNumber;
        System.out.println("The producer produced number: " + itemNumber);
        //releases semaphore after item produced
        Consumer.release();
    }

    void takeFromBuffer() {
        try {
            Consumer.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The consumer consumed number: " + itemNumber);
        Producer.release();
    }
}