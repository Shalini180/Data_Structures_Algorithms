import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = nums.length;
        long sum = 0, ans = 0; 

        while (j < n) {
            while (mp.containsKey(nums[j])) {
                mp.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            mp.put(nums[j], 1);
            sum += nums[j];

            // If the window size is k, update the answer and slide the window
            if (j - i + 1 == k) {
                ans = Math.max(ans, sum);
                // Remove the element at the start of the window from the map and sum
                mp.remove(nums[i]);
                sum -= nums[i];
                i++;
            }

            j++;
        }

        return ans;
    }
}
