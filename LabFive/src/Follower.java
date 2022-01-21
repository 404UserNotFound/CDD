import java.util.concurrent.Semaphore;
/**
 *
 * @author Mihaela B C00242687
 *  date: 1/11/2021
 *  license: GNU General Public License v2.0
 */
public class Follower implements Runnable {

    @Override
    public void run() {
        try{
                mutex.acquire();
                if (leaders> 0) {
                    leaders--;
                    leadersQueue.release();
                }else{
                    followers++;
                    mutex.release();
                    followersQueue.acquire();
                    dance();
                    rendezvous.acquire();
                }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}