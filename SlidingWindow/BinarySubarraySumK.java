class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int length = nums.length;
        int left = 0, right = 0, sum = 0, count = 0, temp = 0;
        
        while (right < length) {
            sum += nums[right];
            if(nums[right] == 1)
                temp = 0;
            
            while (sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }
                
            while (sum == goal && left <= right) {
                temp += 1;
                sum -= nums[left];
                left++;
            }

            count += temp;
            right++;
        }

        return count;
    }
}
