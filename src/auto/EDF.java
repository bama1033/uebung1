/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class EDF {
     public static void checkRSA(ArrayList<Task> list) {
         double sum=0;
          for(int a=0; a < list.size(); a++){
            double c=list.get(a).getComputeOrig();
            double p=list.get(a).getDeadline();
            sum += c/p;
          }
          if (sum<=1)
              System.out.println("EDF Test bestanden");
          else
              System.out.println("EDF Nicht bestanden");
     }
    
}
