package misc;

import java.util.ArrayList;
import java.util.Arrays;

public class mOdd {

	public static void main(String[] args) {
		int [] intArr1 = {-1,4,2,-1};
		int [] intArr2 = {-13,4,-27,9,2,8};
		int [] intArr3 = {2,8};
		findMaxSum(intArr2);
		int count =10;
		while (count >0){
			
			int position =3;
			int temp = intArr1[position];
			for (int i = position-1; i >= 0; i--) {                
				intArr1[i+1] = intArr1[i];
			}
			intArr1[0] = temp;
			System.out.println(Arrays.toString(intArr1));
			
			count --;
		}
		
	}

	private static int findMaxSum(int[] intArr) {
		int currMaxSum;
		int globalMaxSum;
		currMaxSum=globalMaxSum=intArr[0];
		for (int i = 0; i < intArr.length; i++) {
			currMaxSum=Math.max(intArr[i], currMaxSum+intArr[i]);
			if(currMaxSum>globalMaxSum){
				globalMaxSum=currMaxSum;
			}
		}
		System.out.println(globalMaxSum);
		return globalMaxSum;
			
	}

	private static void isMagicOdd(int[] intArr) {
		if(Arrays.stream(intArr).max().getAsInt()%2 != 0){
			if(Arrays.stream(intArr).filter(x-> x%2==0).max().getAsInt() < Arrays.stream(intArr).filter(x-> x%2!=0).min().getAsInt() )
				System.out.println(true);
			else
				System.out.println(false);
		}else{
			System.out.println(false);
		}
	}

}
