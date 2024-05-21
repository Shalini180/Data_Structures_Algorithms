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
	public static int numberOfDivisors(int[] spf, int n){
	   int ans = 1;
	   if(spf[n] == n) return 1;
	   while(n > 1){
	       int c = 0;
	       int factor = spf[n];
	       while(n > 1 && n % factor == 0){
	           c+=1;
	           n = n/factor;
	       }
	       
	       ans = ans*(c+1);
	   }
	   
	   return ans;
	}
	public static void main(String[] args) {
	   int[] spf = spf(1000000);
	   int[] numbers = {40, 600, 7, 99};
	   //int[] numbers = {7};
	   for(int it : numbers){
	        System.out.println("Number of divisors for " + it +" is " + numberOfDivisors(spf, it));
	   }
	}
}
