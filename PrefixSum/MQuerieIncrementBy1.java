import java.util.*;

public class Main
{
	public static void sumArray(int[] arr, int[][] queries){
	    int n = arr.length;
	    int[] prefix = new int[n];
	    Arrays.fill(prefix, 0);
	    
	    for(int i = 0;i<queries.length;i++){
	        int left = queries[i][0];
	        int right = queries[i][1];
	        prefix[left] += 1;
	        if(right < n - 1)
	            prefix[right + 1] -=1;
	    }
	    
	    int pick = 0;
	    for(int i = 0;i<n;i++){
	        if(prefix[i] != 0)
	            pick += prefix[i];
	            
	        arr[i] += pick;
	    }
	    
	}
	
	public static void main(String[] args) {
	    int[] arr = {0,0,0,0,0,0,0};
	    int[][] queries = {{2,6}, {2,3}, {2,5}};
	    sumArray(arr, queries);
	    for(int i = 0;i<arr.length;i++)
	    System.out.print(arr[i] + " ");
	}
}
