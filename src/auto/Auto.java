package auto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Martin
 */
public class Auto {
    public static void main(String[] args) throws IOException {
        //Reading File
        //choose Modus(x)
        //Find Prio (x)
        //Fing KGV(x)
        //RSA
        //Ausgabe(x)

        Task ta =new Task("A",1,3,3);
        Task tb =new Task("B",1,6,6);
        Task tc =new Task("C",1,5,5);
        Task td =new Task("D",2,10,9);
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Martin\\Desktop\\test.txt")))
		{
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
        ArrayList<Task> list = new ArrayList<>();
        
        list.add(ta);
        list.add(tb);
        list.add(tc);
        list.add(td);
        String mode ="RMS";//RMS oder DMS
        
        list = choosePrio(list,mode);
        
        RSA.checkRSA(list);

        
        int kgv= (int) getKGV(list);
        operate(list,kgv);

        System.out.println(kgv);
    }
     
        public static ArrayList<Task>  choosePrio(ArrayList<Task> array,String mode) {
          /*     System.out.println("Before Sorting:");
               System.out.println(array.get(0).getName());
               System.out.println(array.get(1).getName());
               System.out.println(array.get(2).getName());
               System.out.println(array.get(3).getName());*/
         if(mode.equals("RMS")){
	Collections.sort(array);
        return array;}
         
        else if(mode.equals("DMS")){
            Collections.sort(array, new CC());
            return array;}
        
        else
              System.out.println("Falscher mOdus?");
          return array;
                  
          
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
        public static void operate(ArrayList<Task> array, int kgv) {
        //for schleife durch array nach actives checken, falls active gefunden break(+ausgabe) und alle perioden um 1 verkürzen
        //dann wieder array von vorne durchgehen und schauen wer aktiv ist wenn aktiv break(+ausgabe) und subtrahieren
      for (int z = 0; z < kgv; z++){
          if(z!=0){
               for(int a=0; a < array.size(); a++){
                    array.get(a).setPeriod(array.get(a).getPeriod()-1);
                    if(array.get(a).getPeriod()==0 &&array.get(a).getCompute()==0){
                        array.get(a).setCompute(array.get(a).getComputeOrig());
                        array.get(a).setPeriod(array.get(a).getPeriodOrig());
                    }
               }
          }
                 for (int i = 0; i < array.size(); i++){
                    if(array.get(i).getCompute()>0){
                    System.out.print(array.get(i).getName());
                    array.get(i).setCompute(array.get(i).getCompute()-1);
                    break;
                    }
                }
      }      
    }
}