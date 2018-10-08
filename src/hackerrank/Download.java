package hackerrank;


import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Download {

    public  static  void main(String args[]){

      /* Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int [] arrInt = new int[t];
        for (int n = 1; n <= t; n++) {
            int a = sc.nextInt();
            arrInt[n-1]=a;
        }
        TreeMap<Integer,Integer>  map  = new TreeMap<Integer, Integer>();
        for (int i=0; i <arrInt.length;i++)
        {
            int diffNum = diffNum(arrInt[i]);
            if(!map.containsKey(diffNum))
              map.put(diffNum(arrInt[i]),i+1);
        }

        for( Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
        System.out.println(map.lastEntry().getValue() +" "+ map.lastEntry().getKey());
        System.out.println(map.firstEntry().getValue() +" "+ map.firstEntry().getKey());*/

        pressAForCapsLock("My keyboard is broken!");
        System.out.println();
        pressAForCapsLock("\"Baa, Baa!\" said the sheep");

    }



    static String pressAForCapsLock(String message) {

        String arr[] = message.split("");
        boolean toggle=false;
        int count =0;
        for(int i =0; i<arr.length;i++){
            if(arr[i].equalsIgnoreCase("a") && toggle){
                toggle=false;
                count++;
            }
            else if(arr[i].equalsIgnoreCase("a") && !toggle){
                toggle=true;
                count++;
            }
            //System.out.print(arr[i].toUpperCase());
            if(!arr[i].equalsIgnoreCase("a"))
            {
                if(arr[i].toLowerCase()!="a")
                    {
                        if(count >0 &&toggle)
                            System.out.print(arr[i].toUpperCase());
                        else
                            System.out.print(arr[i]);
                    }
            }
        }
        return message;
    }

    public static BigInteger factorial(int number) {
        if (number < 20) {
            return BigInteger.valueOf(
                    LongStream.range(1, number + 1).reduce((previous, current) -> previous * current).getAsLong()
            );
        } else {
            BigInteger result = factorial(19);
            return result.multiply(Stream.iterate(BigInteger.valueOf(20), i -> i.add(BigInteger.ONE)).limit(number - 19)
                    .reduce((previous, current) -> previous.multiply(current)).get()
            );
        }
    }

    private static int diffNum(int N) {

        BigInteger dProduct=factorial(N);
        System.out.println(dProduct);
        String [] strProduct = dProduct.toString().split("");
        int [] intProduct = new int[strProduct.length];
        for (int i = 0; i < strProduct.length; i++) {
            intProduct[i] = Integer.parseInt(strProduct[i]);
        }
        Long XSum = Long.valueOf(Arrays.stream(intProduct).parallel().sum());
        long zeroCount = Arrays.stream(strProduct).filter((str)-> Integer.parseInt(str)==0).count();
        return (int) (XSum-zeroCount);
    }

}
