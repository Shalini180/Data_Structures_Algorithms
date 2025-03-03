class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, zeroes = 0;
        int maxi = 0;
        while(j < n){
            if(nums[j] == 0){
                zeroes ++;
            }

            if(zeroes > k){
                if(nums[i] == 0) zeroes--;
                i++;
            }
            if(zeroes <= k) {
                maxi = Math.max(maxi, j - i + 1);
            }

            j++;
        }

        return maxi;
    }
}
