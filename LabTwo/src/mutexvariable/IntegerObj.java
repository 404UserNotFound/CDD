/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutexvariable;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author joe
 *  edited by: Mihaela Brodetchi C00242687
 *  date: 17/10/2021
 *  license: GNU General Public License v2.0
 */
class IntegerObj {
    int value;
    ReentrantLock mutex = new ReentrantLock();

    IntegerObj(int val) {
        this.value = val;
    }
    int inc(){
        mutex.lock();
        this.value++;
        mutex.unlock();
        return this.value;
    }
}
