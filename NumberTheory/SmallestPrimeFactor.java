import java.util.*;
public class Main
{
	public static int[] spf(int n){
	    int[] ans = new int[n+1];
	    for(int i = 2;i<=n;i++){
	        if(ans[i] > 0) continue;
	        ans[i] = i;
	        if((long) i*i > (long) n) continue;
	        for(int j = i*i;j<=n;j+=i){
	            ans[j] = i;
	        }
	    }
	    
	    return ans;
	}
	public static void main(String[] args) {
	    int n = 20;
		int[] ans = spf(n);
		for(int i = 2;i<=n;i++)
		System.out.println(i + " " + ans[i]);
	}
}
