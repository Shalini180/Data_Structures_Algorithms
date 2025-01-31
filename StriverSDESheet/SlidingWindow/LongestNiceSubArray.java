class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int mask = 0, ans = 0;
        while(j < n){
            while((mask & nums[j]) != 0) {
                mask = mask ^ nums[i];
                i++;
            }

            mask = mask | nums[j];
            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}
