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
class RunnableDemo implements Runnable {
   private Thread t;
   /**
    * Assign name to each thread.
    */
   private String threadName;
   RunnableDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }

   /**
    * Print thread messsage.
    */
   @Override
   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            /**
             * Iterate message 4 times.
             */
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      /**
       * Returns exit message.
       */
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
