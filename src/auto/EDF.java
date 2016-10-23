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
     public static void checkRSA(ArrayList<Task> array) {
         double sum=0;
          for(int a=0; a < array.size(); a++){
              double c=array.get(a).getComputeOrig();
              double p=array.get(a).getDeadline();
               sum += c/p;
          }
          if (sum<=1)
               System.out.println("EDF Test bestanden");
          else
              System.out.println("EDF Nicht bestanden");
     }
    
}
