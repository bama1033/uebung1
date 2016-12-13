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
        //RTA
        //Ausgabe(x)
        Task ta =new Task("A",1,3,3);
        Task tb =new Task("B",1,6,6);
        Task tc =new Task("C",1,5,5);
        Task td =new Task("D",2,10,9);
        
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Martin\\Desktop\\test.txt")))
		{
		    String sCurrentLine;
                    while ((sCurrentLine = br.readLine()) != null) {
			//System.out.println(sCurrentLine);
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
        
    //    RTA.checkRTA(list);
        int kgv= (int) KGV.getKGV(list);
        operate(list,kgv);
    }
        public static ArrayList<Task>  choosePrio(ArrayList<Task> list,String mode) {
          /*   System.out.println("Before Sorting:");
               System.out.println(list.get(0).getName());
               System.out.println(list.get(1).getName());
               System.out.println(list.get(2).getName());
               System.out.println(list.get(3).getName());*/
         if(mode.equals("RMS")){
            Collections.sort(list);
            return list;}
         
        else if(mode.equals("DMS")){
            Collections.sort(list, new CC());
            return list;}
        else
              System.out.println("Falscher mOdus?");
          return list;  
        }


        public static void operate(ArrayList<Task> list, int kgv) {
        //for schleife durch list nach actives checken, falls active gefunden break(+ausgabe) und alle perioden um 1 verkürzen
        //dann wieder list von vorne durchgehen und schauen wer aktiv ist wenn aktiv break(+ausgabe) und subtrahieren
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