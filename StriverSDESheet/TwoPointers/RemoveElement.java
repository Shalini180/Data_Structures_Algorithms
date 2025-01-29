class Solution {
    public int helper(int[] nums, int val){
        int n = nums.length;
        int next = 0;
        int i = 0;
        while(i < n) {
            if(nums[i] != val){
                nums[next] = nums[i];
                next++;
            }

            i++;
        }
        
        return next;
    }
    public int removeElement(int[] nums, int val) {
        return helper(nums, val);
    }
}
