/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author MikeRD
 */
public class ArrayListTests {
 public static void main(String[] args){
     ArrayList<String> aa = new ArrayList<String>();
     aa.add("Hi");
     aa.add("Bye");
     ArrayList<String> b = new ArrayList<String>(aa);
     Collections.sort(aa);
     for (String x:aa){
         System.out.println(x);
     }
     System.out.println("-----");
     for (String x:b){
         System.out.println(x);
     }

 }   
}
