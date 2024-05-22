import java.util.*;

public class Main
{
	public static int[] spf(int n){
	    int[] spf = new int[n + 1];
	    for(int i = 2; i<=n;i++){
	        if(spf[i] > 0) continue;
	        spf[i] = i;
	        if((long) i*i > (long)n) continue;
	        for(int j = i*i;j<=n;j+=i) spf[j] = i;
	    }
	    
	    return spf;
	}
	
	public static int getPrime(int n, int[] spf){
	    int factor = spf[n];
	    if(factor == n) return 1;
	    int c = 0; 
	    while(n > 1){
	        c+=1;
	        n = n/factor;
	        factor = spf[n];
	   }
	   
	   return c;
	}
	
	public static void main(String[] args) {
	    int[] spf = spf(500000);
	    int[] prime = new int[500001];
	    int[] prefix = new int[500001];
	    for(int i = 2;i<500001;i++){
	        prime[i] = getPrime(i, spf);
	        prefix[i] = prefix[i-1] + prime[i];
	    }
	    
	    int a = 6;int b = 3;
	    System.out.println("Maximum Divisors of a!/b! " + (prefix[a] - prefix[b]));
	}
}
