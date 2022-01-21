/**
 *
 * @author Mihaela B C00242687
 *  date: 1/11/2021
 *  license: GNU General Public License v2.0
 */
public class Leader implements Runnable {

    @Override
    public void run() {
            try{

                mutex.acquire();
                if (followers > 0) {
                    followers--;
                    followerQueue.release();
                }else{
                    leaders++;
                    mutex.acquire();
                    leaderQueue.acquire();
                    dance();

                    rendezvous.acquire();
                    mutex.release();
                }

            }catch(InterruptedException e){
                e.printStackTrace();
            }

    }
}