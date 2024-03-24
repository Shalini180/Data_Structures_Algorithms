public class Main
{
	public static void checkElementsFoundByBs(int[] arr){
	    int n = arr.length;
	    int[] prefix = new int[n];
	    int[] suffix = new int[n];
	    for(int i = 0;i<n;i++){
	        prefix[i] = (i == 0) ? Integer.MIN_VALUE : Math.max(prefix[i-1], arr[i-1]);
	    }
	    for(int j = n - 1;j>=0;j--){
	        suffix[j] = (j == n - 1) ? Integer.MAX_VALUE : Math.min(suffix[j + 1], arr[j + 1]);
	    }
	    for(int i = 0;i<n;i++){
	        if(i == 0){
	            if(arr[i] < suffix[i])
	                System.out.println(arr[i]);
	        }
	        else if(i == n - 1){
	            if(arr[i] > prefix[i])
	                System.out.println(arr[i]);
	        }
	        else{
	            if(arr[i] > prefix[i] && arr[i] < suffix[i])
	                System.out.println(arr[i]);
	        }
	    }
	}
	public static void main(String[] args) {
	    int[] arr = {1,6,4,7,10,9};
	    checkElementsFoundByBs(arr);
	}
}
