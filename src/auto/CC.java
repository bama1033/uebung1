/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;
import java.util.Comparator;
/**
 *
 * @author Martin
 */

//Comparator for Deadlineattribute
public class CC implements Comparator<Task>{

    @Override
    public int compare(Task o1, Task o2) {
        if(o1.getDeadline()> o2.getDeadline()){
            return  1;
    }else if (o1.getDeadline()< o2.getDeadline()){
        return -1;
    }
    return 0;
}
}
