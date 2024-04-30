import java.util.*;

public class Main
{
	public static int sequence(int n){
	    Queue<Integer> q = new LinkedList<>();
	    
	    q.add(2);
	    q.add(3);
	    q.add(5);
	    
	    for(int i = 0;i < n - 1;i++){
	        int ele = q.peek();
	        q.poll();
	        
	        q.add(10*ele + 2);
	        q.add(10*ele + 3);
	        q.add(10*ele + 5);
	    }
	    
	    return q.peek();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(n + "th Number with 2, 3, 5 is " + sequence(n));
	}
}
