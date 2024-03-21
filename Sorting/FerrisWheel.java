import java.util.*;

public class Main
{
	public static int helper(int[] arr, int x){
	    Arrays.sort(arr);
	    int i = 0, j = arr.length - 1;
	    int ans = 0;
	    while(i <= j){
	        int combinedSum = arr[i] + arr[j];
	        if(combinedSum <= x){
	            ans += 1;
	            i++;
	            j--;
	        }
	        else{
	            ans += 1;
	            j--;
	        }
	    }
	    
	    return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0;i<n;i++)
		    arr[i] = sc.nextInt();
		System.out.println(helper(arr, x));
	}
}
