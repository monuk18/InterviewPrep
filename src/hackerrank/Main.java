package hackerrank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCase=Integer.parseInt(sc.nextLine() );
        for(int i=0;i<testCase;i++){
            int StudentsCount= Integer.parseInt(sc.nextLine());
            String arrString[] = sc.nextLine().split(" ");
            int arr[] = new int[arrString.length];
            for(int c=0;c<arrString.length;c++){
                arr[c] = Integer.parseInt(arrString[c]);
            }
            sysoTallest(arr);

        }

        Singleton s1= Singleton.getSingleton();

    }

    private static void sysoTallest(int[] arr) {
        int maximumCount=0;
        int maximumIndex=0;
        for(int j=0;j<arr.length;j++){
            int count=0;
            int k=j+1;
            while( k< arr.length && arr[j] > arr[k]){
                count++;
                if(k<arr.length)
                k++;
            }
            if( k<arr.length && arr[k]!=arr[j] )
            count += 1;

            if(maximumCount<count){
                maximumCount=count;
                maximumIndex=j;
            }else if(maximumCount == count){
                maximumIndex=j;
            }

        }
        System.out.println(maximumIndex+1);
    }
}

class   Singleton{

    public  static  Singleton instance  = new  Singleton();

    private Singleton() {

    }

    public static   Singleton getSingleton(){
        return instance;
    }

}
