/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package originalcode;

/**
 *
 * @author joe
 *  edited by: Mihaela Brodetchi C00242687
 *  date: 11/10/2021
 *  license: GNU General Public License v2.0
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
