import java.util.*;

public class Main
{
	public static void printAnswerQueries(int[] arr, int[] queries){
	    int n = arr.length;
	    int m = queries.length;
	    int[] prefix = new int[n];
	    int[] suffix = new int[n];
	    for(int i = 0;i<n;i++){
	        prefix[i] = (i == 0) ? arr[i] : Math.max(arr[i], prefix[i-1]);
	    }
	    for(int i = n-1;i>=0;i--){
	        suffix[i] = (i == n - 1) ? arr[i] : Math.max(arr[i], suffix[i + 1]);
	    }
	    
	    for(int i = 0;i<m;i++){
	        int ans = (int)-1e6;
	        int ind = queries[i];
	        ans = (ind == 0) ? suffix[ind+1] : Math.max(ans, prefix[ind - 1]);
	        ans = (ind == n - 1) ? prefix[ind-1] : Math.max(ans, suffix[ind + 1]);
	        System.out.println("For Index i," + ind +" Max element excluding ith element is: " + ans);
	    }
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,9,7,8,5,10};
		int[] queries = {0,7,3,2};
		printAnswerQueries(arr, queries);
	}
}
