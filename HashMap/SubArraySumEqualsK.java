class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0, ans = 0;
        prefixMap.put(0,1);
        
        for(int i = 0;i < nums.length;i++){
            prefixSum += nums[i];
            int findEle = prefixSum - k;
            ans += prefixMap.getOrDefault(findEle, 0);

            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}
