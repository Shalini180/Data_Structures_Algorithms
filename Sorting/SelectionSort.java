class Solution
{
	void selectionSort(int arr[], int n)
	{
	    for(int i = 0;i<n-1;i++){
	        int mini = Integer.MAX_VALUE, index = -1;
	        for(int j = i;j<n;j++){
	            if(arr[j] < mini){
	                mini = arr[j];
	                index = j;
	            }
	        }
	        
	        int temp = arr[i];
	        arr[i] = arr[index];
	        arr[index] = temp;
	    }
	}
}
