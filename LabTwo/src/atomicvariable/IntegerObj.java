/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atomicvariable;

/**
 *
 * @author joe
 */
class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }
    int inc(){
        this.value++;
        return this.value;
    }
}
