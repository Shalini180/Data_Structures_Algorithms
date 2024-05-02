class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int pairs = 0;
        for(int it : nums){
            int freq = mp.getOrDefault(it, 0);
            pairs += freq;
            mp.put(it, freq + 1);
        }

        return pairs;
    }
}
