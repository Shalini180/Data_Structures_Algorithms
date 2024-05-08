class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int sum = 0, ans = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while(j < n){
            sum += nums[j];
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            if(mp.size() == j - i + 1) ans = Math.max(ans, sum);
            else{
                while(mp.size() < j - i + 1){
                    int freq = mp.get(nums[i]);
                    sum -= nums[i];
                    if(freq == 1) mp.remove(nums[i]);
                    else mp.put(nums[i], freq - 1);
                    i++;
                }
            }

            j++;
        }

        return ans;
    }
}
