/**
 * @author Mihaela B C00242687
 *  date: 17/1/2022
 *  license: GNU General Public License v2.0
 *Create a Java project that shows a solution to the producers-consumers problem.
 * The solution must be implemented as one or more Java classes that utilises only semaphores.
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Consumer(queue);
        new Producer(queue);
    }
}