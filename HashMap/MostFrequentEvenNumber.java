class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int it : nums){
            if(it%2 == 0){
                mp.put(it, mp.getOrDefault(it, 0) + 1);
            }
        }

        int maxi_freq = -1, max_ele = -1;
        for(Map.Entry<Integer, Integer> ele : mp.entrySet()){
            int currFreq = ele.getValue();
            if(currFreq > maxi_freq){
                maxi_freq = currFreq;
                max_ele = ele.getKey();
            }
            else if(currFreq == maxi_freq) max_ele = Math.min(max_ele, ele.getKey());
        }

        return max_ele;
    }
}
