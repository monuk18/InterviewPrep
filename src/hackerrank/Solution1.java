package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution1 {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        Map<String,String> map =new LinkedHashMap<String,String>();
        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];
            map.put(contact,op);
        }
        scanner.close();
        ArrayList<String>  arrLst = new ArrayList<String>();
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        System.out.println("                   ");
         while(iterator.hasNext()) {
             Map.Entry s = (Map.Entry)iterator.next();
            // System.out.print(s.getValue()+" "+s.getKey()+" ");
             if(((String)s.getValue()).equalsIgnoreCase("add")){
                arrLst.add((String)s.getKey());
            }
             if(((String)s.getValue()).equalsIgnoreCase("find")){
               System.out.println(
                   arrLst
                   .stream()
                   .filter( str -> str.startsWith((String)s.getKey())).count());
            }
         }
       /* for(Map.Entry<String,String> s : map.entrySet()){
            if(s.getValue().equalsIgnoreCase("add")){
                // System.out.println("adding  "+s.getKey());
                arrLst.add(s.getKey());
            }
            if(s.getValue().equalsIgnoreCase("find")){                                                             //System.out.println("finding  "+s.getKey());
               System.out.println(
                   arrLst
                   .stream()
                   .filter( str -> str.startsWith(s.getKey())).count());
            }
            
        }*/
        //System.out.println(arrLst);
        

        
    }
}

