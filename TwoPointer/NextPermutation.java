class Solution {
    public void reverseArray(int[] nums, int start, int end){
        while(start <  end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index1 = length - 2;

        while(index1 >= 0 && nums[index1] >= nums[index1 + 1])
            index1--;
        
        int index2 = length - 1;
        if(index1 >= 0){
            while(index2 >= 0 && nums[index2] <= nums[index1])
                index2--;

            int temp = nums[index2];
            nums[index2] = nums[index1];
            nums[index1] = temp;
        }

        reverseArray(nums, index1 + 1, length - 1);
    }
}
