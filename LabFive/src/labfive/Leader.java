package labfive;

public class Leader {
    mutex.wait()
            if followers > 0:
    followers--
            followerQueue.signal()
            else:
    leaders++
            mutex.signal()
            leaderQueue.wait()
    dance()
rendezvous.wait()
        mutex.signal()
}
