import java.util.Random;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Mihaela B C00242687
 *  date: 20/12/2021
 *  license: GNU General Public License v2.0
 *
 *  Create a Java project that shows a solution to theDining philosophers problem.
 *  The solution must be implemented as one or more Java classes that utilises only semaphores.
 */

public class Philosophers {

    private final Semaphore[] chopsticks = new Semaphore[5];
    private static final Random random = new Random(System.currentTimeMillis());

    public Philosophers() {
        chopsticks[0] = new Semaphore(1);
        chopsticks[1] = new Semaphore(1);   //initialise semaphores
        chopsticks[2] = new Semaphore(1);
        chopsticks[3] = new Semaphore(1);
        chopsticks[4] = new Semaphore(1);
    }

    public void philosopherActions(int id) throws InterruptedException {

        while (true) {
            think(id);
            eat(id);
        }
    }

    static void runPhilosopher(Philosophers diningPhil, int id) {
        try {
            diningPhil.philosopherActions(id);  //start eating and thinking
        } catch (InterruptedException ie) {

        }
    }

    void think(int id) throws InterruptedException {
        System.out.println(String.format("Philosopher %d is thinking.", id)); //think then sleep
        Thread.sleep(random.nextInt(50));
    }

    void eat(int idNum) throws InterruptedException {
        int leftHand = idNum;
        int rightHand = (idNum!=0)? idNum-1 : 4;
        System.out.println(String.format("Philosopher %d attempts to take left chopstick.", idNum));
        chopsticks[leftHand].acquire();
        System.out.println(String.format("Philosopher %d successfully picks up left chopstick.", idNum));
        System.out.println(String.format("Philosopher %d attempts to take right chopstick.", idNum));
        if (chopsticks[rightHand].tryAcquire()) {       //attempts to acquire semaphore permit, if a permit is not available, thread returns false value
            System.out.println(String.format("Philosopher %d successfully picks up right chopstick.", idNum));
            currentlyEating(idNum);
            System.out.println(String.format("Philosopher %d puts right chopstick down.", idNum));
            chopsticks[rightHand].release();
        }
        System.out.println(String.format("Philosopher %d puts left chopstick down.", idNum));
        chopsticks[idNum].release();
    }

    private void currentlyEating(int id) throws InterruptedException {
        System.out.println(String.format("Philosopher %d currently eating", id)); //eat then sleep
        Thread.sleep(random.nextInt(50));
    }


    public static void startDinner() throws InterruptedException {  //create philosopher threads
        final Philosophers diningPhilosopher = new Philosophers();

        Thread philosopherOne = new Thread(new Runnable() {

            public void run() {
                runPhilosopher(diningPhilosopher, 0);
            }
        });

        Thread philosopherTwo = new Thread(new Runnable() {

            public void run() {
                runPhilosopher(diningPhilosopher, 1);
            }
        });

        Thread philosopherThree = new Thread(new Runnable() {

            public void run() {
                runPhilosopher(diningPhilosopher, 2);
            }
        });

        Thread philosopherFour = new Thread(new Runnable() {

            public void run() {
                runPhilosopher(diningPhilosopher, 3);
            }
        });

        Thread philosopherFive = new Thread(new Runnable() {

            public void run() {
                runPhilosopher(diningPhilosopher, 4);
            }
        });

        philosopherOne.start();
        philosopherTwo.start();
        philosopherThree.start();
        philosopherFour.start();
        philosopherFive.start();

        philosopherOne.join();
        philosopherTwo.join();
        philosopherThree.join();
        philosopherFour.join();
        philosopherFive.join();
    }
}