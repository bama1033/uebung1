/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Martin
 */
public class RTA {
    public static void checkRTA(ArrayList<Task> list) {
       // for(int a=0; a < array.size(); a++){
       checkRTA(list.get(0),list.get(1),list.get(2),list.get(3));
    //  checkRTA(list.get(0));
   //    checkRTA(list.get(1),list.get(0));
        //    checkRTAsingle3(array.get(2));
        //    checkRTAsingle4(array.get(3));    
    }
    //optimale Prioritätsvergabe
    public static void checkRTA(Task i) {
        int comp=i.getComputeOrig();
        int r=comp;
        checkD(r,i.getDeadline());
        System.out.println("r is" +r);
    }
    public static void checkRTA(Task i,Task j1) {
        int ci=i.getComputeOrig();
        int ta = j1.getPeriodOrig();
        int cj= j1.getComputeOrig();
        int r=ci;
        int r1=0;
        int iteration=1;
        
        r=ci+calc( r, ta, cj);
        r1=ci+calc( r, ta, cj);
        //for schleife, r==r1 if yes weiter, else weiter methode calc durchgehen
        while (r!=r1) {
            r=r1;
           r1=ci+calc( r, ta, cj);
           iteration++;
           checkD(r,i.getDeadline());
       }
        System.out.println("r is " +r);
        System.out.println("r1 is " +r1);
   }
    public static void checkRTA(Task i,Task j1,Task j2) {
        int ci=i.getComputeOrig();
        int t1 = j1.getPeriodOrig();
        int t2 = j2.getPeriodOrig();
        int cj1=j1.getComputeOrig();
        int cj2=j2.getComputeOrig();
        int r=ci;
        int r1=0;
        int iteration=1;
        
        r=ci+(calc(r, t1, cj1)+calc(r, t2, cj2));
        r1=ci+(calc(r, t1, cj1)+calc(r, t2, cj2));
        //for schleife, r==r1 if yes weiter, else weiter methode calc durchgehen
        while (r!=r1) {
           checkD(r,i.getDeadline());
           r=r1;
           r1=ci+(calc(r, t1, cj1)+calc(r, t2, cj2));
           iteration++;
           System.out.println("iteration was " +iteration);
       }
        System.out.println("r is " +r);
        System.out.println("r1 is " +r1);
        System.out.println("iteration was " +iteration);
   }
   
   public static void checkRTA(Task i,Task j1,Task j2,Task j3) {
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
           System.out.println("iteration was " +iteration);
       }
        System.out.println("r is " +r);
        System.out.println("r1 is " +r1);
        System.out.println("iteration was " +iteration);
   }
 
    public static int calc(int r,int t,int cj) {
        int x=0;
        x=((divide(r,t))*cj);
        return x;
    }
   
    public static void checkD(int r,int d) {
        if (r>=d)
            System.out.println("DeadLine überschritten, RTA gescheitert");
        Exception Exception = null;
        try {
            throw Exception    ;
        } catch (Exception ex) {
            Logger.getLogger(RTA.class.getName()).log(Level.SEVERE, null, ex);
        }
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
