class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void heapify(int[] nums, int i, int n){
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && nums[left] > nums[smallest]) smallest = left;
        if(right < n && nums[right] > nums[smallest]) smallest = right;

        if(smallest != i){
            swap(nums, i, smallest);
            heapify(nums, smallest, n);
        }
    }
    public void buildHeap(int [] nums){
        int n = nums.length;
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(nums, i, n);
        }
    }
    public void heapSort(int[] nums){
        int n = nums.length;
        for(int i = n-1; i > 0; i--){
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }
    public int[] sortArray(int[] nums) {
        buildHeap(nums);
        heapSort(nums);
        
        return nums;
    }
}
