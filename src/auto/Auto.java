/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Martin
 */
public class Auto {
    public static void main(String[] args) {
        // TODO 
        //Reading File
        //choose Modus
        //Find Prio (x)
        //Fing KGV(x)
        //Ausgabe
        //Deadline überschreitung
        Task ta =new Task("A",1,3,3);
        Task tb =new Task("B",1,6,6);
        Task tc =new Task("C",1,5,5);
        Task td =new Task("D",2,10,9);
        ArrayList<Task> list = new ArrayList<>();
        list.add(ta);
        list.add(tb);
        list.add(tc);
        list.add(td);
        String modus= chooseModus("RMS");
        list = choosePrio(list);
        
        int kgv= (int) getKGV(list);
        operate(list,kgv);
        System.out.println("Hi");
        System.out.println(kgv);
    }
    
    public static String chooseModus(String mode) {
        return "RMS";
        //rms DMS kann über Task setPrio gmeacht werden
    }
    
        public static ArrayList<Task>  choosePrio(ArrayList<Task> mode) {
          /*     System.out.println("Before Sorting:");
               System.out.println(mode.get(0).getName());
               System.out.println(mode.get(1).getName());
               System.out.println(mode.get(2).getName());
               System.out.println(mode.get(3).getName());*/
	   Collections.sort(mode);
        return mode;
    }

        private static long gcd(long a, long b){
            while (b > 0){
                long temp = b;
                b = a % b; // % is remainder
                a = temp;
            }
            return a;
        }
        private static long lcm(int a, int b){
            return a * (b / gcd(a, b));
        }
        private static long getKGV(ArrayList<Task> list){
             int result = list.get(0).getPeriod();
             for(int i = 1; i < list.size(); i++) 
                 result = (int) lcm(result, list.get(i).getPeriod());
             return result;
        }
    public static void operate(ArrayList<Task> list, int kgv) {
        //for schleife durch array nach actives checken, falls active gefunden break(+ausgabe) und alle perioden um 1 verkürzen
        //dann wieder array von vorne durchgehen und schauen wer aktiv ist wenn aktiv break(+ausgabe) und subtrahieren
      for (int z = 0; z < kgv; z++){
          if(z!=0){
               for(int a=0; a < list.size(); a++){
                    list.get(a).setPeriod(list.get(a).getPeriod()-1);
                    if(list.get(a).getPeriod()==0 &&list.get(a).getCompute()==0){
                        list.get(a).setCompute(list.get(a).getComputeOrig());
                        list.get(a).setPeriod(list.get(a).getPeriodOrig());
                    }
               }
          }
                 for (int i = 0; i < list.size(); i++){
                    if(list.get(i).getCompute()>0){
                    System.out.print(list.get(i).getName());
                    list.get(i).setCompute(list.get(i).getCompute()-1);
                    break;
                    }
                }
      }      
    }
}

/*
               for(int a=0; a < list.size(); a++){
                    int C= list.get(a).getActive();
                    C=C-1;
                    list.get(a).setActive(C);
               }
*/
/*
            if(list.get(i).getActive() <=0){
                System.out.print(list.get(i).getName());
                list.get(i).setActive(list.get(i).getPeriod());

                break;
            }
*/