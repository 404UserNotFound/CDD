/**
 *
 * @author Mihaela B C00242687
 *  date: 20/12/2021
 *  license: GNU General Public License v2.0
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Print("Running Dining Philosophers");
        Philosophers.startDinner();

    }
    public static void Print(Object o){
        System.out.println(o);
    }
}
