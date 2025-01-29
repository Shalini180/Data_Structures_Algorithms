class Solution {
    public int helper(int[] nums, int target){
        Arrays.sort(nums);
        int small = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int diff = target - nums[i] - nums[j] - nums[k];
                if(diff == 0){
                    return target - diff;
                }
                else if(Math.abs(diff) < Math.abs(small)){
                    small = diff;
                }

                if(diff > 0) j++;
                else k--;
            }
        }

        return target - small;
    }
    public int threeSumClosest(int[] nums, int target) {
        return helper(nums, target);
    }
}
