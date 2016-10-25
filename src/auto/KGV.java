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
public class KGV {
            public static long gcd(long a, long b){
            while (b > 0){
                long temp = b;
                b = a % b; // % is remainder
                a = temp;
            }
            return a;
        }
        public static long lcm(int a, int b){
            return a * (b / gcd(a, b));
        }
        public static long getKGV(ArrayList<Task> list){
             int result = list.get(0).getPeriod();
             for(int i = 1; i < list.size(); i++) 
                 result = (int) lcm(result, list.get(i).getPeriod());
             return result;
        }
}
