/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RunnableDemo;

/**
 * @author KEHOEJ
 * edited by: Mihaela Brodetchi C00242687
 * 5/10/2021
 * GNU General Public License v2.0
 */

/**
 * Create threads and run.
 */
public class TestThread {
    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
    }   
    
}
