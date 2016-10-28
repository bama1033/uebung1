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
       checkRTA4(list.get(0),list.get(1),list.get(2),list.get(3));
       //     checkRTAsingle1(list.get(0));
        //    checkRTAsingle2(list.get(1),list);
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
        
        r=ci+calc( r, ta, cj);
        r1=ci+calc( r, ta, cj);
        //for schleife, r==r1 if yes weiter, else weiter methode calc durchgehen
        while (r==r1) {
            r=r1;
           r1=ci+calc( r, ta, cj);
           iteration++;
       }
        checkD(r,t.getDeadline());
   }
   
   //checkRTA mit 4 paramtern erster parameter ist hp(a) rest sind die ausgeschlossenen, dann quasi checkrta4
   public static void checkRTA4(Task i,Task j1,Task j2,Task j3) {
        int ci=i.getComputeOrig();
        int t1 = j1.getPeriodOrig();
        int t2 = j2.getPeriodOrig();
        int t3 = j3.getPeriodOrig();
        int cj1=j1.getComputeOrig();
        int cj2=j2.getComputeOrig();
        int cj3=j3.getComputeOrig();
        int r=ci;
        int r1=0;
        int iteration=1;
        
        r=ci+(calc(r, t1, cj1)+calc(r, t2, cj2)+calc( r, t3, cj3));
        r1=ci+(calc(r, t1, cj1)+calc(r, t2, cj2)+calc( r, t3, cj3));
        //for schleife, r==r1 if yes weiter, else weiter methode calc durchgehen
        while (r!=r1) {
           checkD(r,i.getDeadline());
           r=r1;
           r1=ci+(calc(r, t1, cj1)+calc(r, t2, cj2)+calc( r, t3, cj3));
           iteration++;
       }
        
        System.out.println("r is " +r);
        System.out.println("r1 is " +r1);
   }
   
  /*       public static int checkRTAsingle3(Task t,int a,int b) {
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
   }*/
   
    public static int calc(int r,int t,int cj) {
        int x=0;
         x=((divide(r,t))*cj);
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
