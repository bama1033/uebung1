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
public class RSA {
    public static void checkRSA(ArrayList<Task> array) {
       // for(int a=0; a < array.size(); a++){
            int a=checkRSAsingle1(array.get(0));
            int b=checkRSAsingle2(array.get(1),array,a);
            int c=checkRSAsingle3(array.get(2),a,b);
            int d=checkRSAsingle4(array.get(3),a,b,c);
                  
    }

    public static int checkRSAsingle1(Task t) {
        int comp=t.getComputeOrig();
        int d=t.getDeadline();
        int r=comp;
        if(comp<d)
            return comp;
        else
            return -1;
    }
   public static int checkRSAsingle2(Task t,ArrayList<Task> array,int a) {
        int comp=t.getComputeOrig();
        int d=t.getDeadline();
        int r=comp+(a/array.get(0).periodOrig)*array.get(0).compute;


                
                if(comp<d)
            return comp;
        else
            return -1;
   }
      public static int checkRSAsingle3(Task t,int a,int b) {
        int comp=t.getComputeOrig();
        int d=t.getDeadline();
        int r0=comp;

        if(comp<d)
            return comp;
        else
            return -1;
   }
         public static int checkRSAsingle4(Task t,int a, int b, int c) {
        int comp=t.getComputeOrig();
        int d=t.getDeadline();
        int r0=comp;

        if(comp<d)
            return comp;
        else
            return -1;
   }
         public static int Divide(int a,int b){
            int x=0;
             if (a/b>=1)
             {
               x=2;
             }
             else
             {
                x=1;
             }
             return x;
         }
    
}
