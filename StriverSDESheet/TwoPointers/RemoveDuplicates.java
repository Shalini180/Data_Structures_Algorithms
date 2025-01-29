class Solution {
    public int helper(int[] nums){
        int n = nums.length;
        int i = 1, next = 1;
        while(i < n){
            if(nums[next - 1] != nums[i]){
                nums[next] = nums[i];
                next++;
            }

            i++;
        }

        return next;
    }
    public int removeDuplicates(int[] nums) {
        return helper(nums);
    }
}
