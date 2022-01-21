package labfive;

import java.util.concurrent.Semaphore;
/**
 *
 * @author Mihaela Brodetchi C00242687
 *  date: 1/11/2021
 *  license: GNU General Public License v2.0
 */

public class Follower implements Runnable {
    private final String followerName;
    private final Queue queue;
    private Queue followersQueue;
    Semaphore queueSemaphore;
    private final Semaphore rendezvous = new Semaphore(0);
    public int followersCount = 0;
    Semaphore mutex = new Semaphore(1);


    public Follower(String followerName, Queue queue){
        this.followerName = followerName;
        this.queue = queue;
    }
    public void run() {
       try{
           mutex.acquire();
           if(Leader.leadersCount > 0){
               Leader.leadersCount--;
               Leader.leadersQueue.signalThread();
           }
           else{
               followersCount++;
               mutex.release();
               followersQueue.wait(queueSemaphore);
           }
           Queue.dance("Follower " + followerName + "dancing");
           rendezvous.release();
        } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
/** Pseudo from Little Book of Semaphores
 mutex.wait()
 if leaders> 0:
 leaders--
 leadersQueue.signal()
 else:
 followers++
 mutex.signal()
 followersQueue.wait()
 dance()
 rendezvous.wait()*/