/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronised;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author joe
 *  edited by: Mihaela Brodetchi C00242687
 *  date: 11/10/2021
 *  license: GNU General Public License v2.0
 */
public class Task implements Runnable {
private String name;
    private IntegerObj total;
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }
    
    public void run()
    {
        try {
                for (int i = 0; i < 500; i++) {
                    total.inc();
                    if (i % 100 == 0) {
                        Thread.sleep(100);
                    }

                }
                System.out.println(name + " complete");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
