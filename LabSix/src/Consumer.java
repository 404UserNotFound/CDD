/**
 * @author Mihaela B C00242687
 *  date: 17/1/2022
 *  license: GNU General Public License v2.0
 *Create a Java project that shows a solution to the producers-consumers problem.
 * The solution must be implemented as one or more Java classes that utilises only semaphores.
 */
public class Consumer implements Runnable {
    Queue queue;
    int index;
    Consumer(Queue queue) {
        this.queue = queue;
        new Thread(this, "Consumer").start();
        //initialise new consumer thread
    }
    public void run() {
        for (index = 0; index < 5; index++)
            queue.takeFromBuffer();
    }
}