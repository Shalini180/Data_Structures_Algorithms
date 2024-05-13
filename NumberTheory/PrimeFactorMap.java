import java.util.*;

public class Main
{
	static Map<Integer, Integer> primeFactors(int n){
	    Map<Integer, Integer> mp = new HashMap<>();
	    for(int i = 2;i*i<=n;i++){
	        if(n%i != 0) continue;
	        int c = 0;
	        while(n%i == 0){
	            c += 1;
	            n = n/i;
	        }
	        
	        mp.put(i, c);
	    }
	    
	    if(n > 1) mp.put(n, 1);
	    return mp;
	}
	public static void main(String[] args) {
		int n = 33;
		Map<Integer, Integer> mp = primeFactors(n);
		for(Map.Entry<Integer, Integer> it : mp.entrySet()){
		    System.out.println(it.getKey() + " " + it.getValue());
		}
	}
}
