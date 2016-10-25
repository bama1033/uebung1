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
public class RTA {
    public static void checkRTA(ArrayList<Task> list) {
       // for(int a=0; a < array.size(); a++){
            checkRTAsingle1(list.get(0));
            checkRTAsingle2(list.get(1),list);
        //    checkRTAsingle3(array.get(2));
        //    checkRTAsingle4(array.get(3));
                  
    }

    public static void checkRTAsingle1(Task t) {
        int comp=t.getComputeOrig();
        int r=comp;
        checkD(r,t.getDeadline());
    }
   public static void checkRTAsingle2(Task t,ArrayList<Task> array) {
        int ci=t.getComputeOrig();
        int ta = array.get(0).getPeriodOrig();
        int cj=array.get(0).getComputeOrig();
        int r=ci;
        int r1=0;
        int iteration=1;
        
        r=calc(ci, r, ta, cj);
        r1=calc(ci, r, ta, cj);
        //for schleife, r==r1 if yes weiter, else weiter methode calc durchgehen
        while (r==r1) {
            r=r1;
           r1=calc(ci, r, ta, cj);
           iteration++;
       }
        checkD(r,t.getDeadline());
   }
         public static int checkRTAsingle3(Task t,int a,int b) {
        int cc=t.getComputeOrig();
        int d=t.getDeadline();
       int r=cc;
  //      int r1 = cc+(divide(r0, d)*);
//int r2 =;//if r1=r2 then r=r1 else use r2 as r1 now
        if(r<d)
            return r;
        else
            return -1;
   }
         public static int checkRTAsingle4(Task t,int a, int b, int c) {
        int comp=t.getComputeOrig();
        int d=t.getDeadline();
        int r=comp;

        if(r<d)
            return r;
        else
            return -1;
   }
   
    public static int calc(int ci,int r,int t,int cj) {
        int x=0;
         x=ci+((divide(r,t))*cj);
         return x;
    }
   
    public static void checkD(int r,int d) {
             if (r>=d)
            System.out.println("DeadLine überschritten, RTA gescheitert");

    }
        public static int divide(int a,int b){
            int x=0;
             if (a % b==0)
             {
               x=a/b;
             }
             else
             {
                 x=a/b;
                 x=x+1;
             }
             return x;
         }
    
}
