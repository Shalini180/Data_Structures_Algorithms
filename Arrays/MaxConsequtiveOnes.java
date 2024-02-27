class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones = 0;
        int l = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                l +=1;
            }
            else if(nums[i] == 0){
                l = 0;
            }
           
            max_ones = Math.max(max_ones, l);
        }


        return max_ones;
    }
}
