class Solution {
    public int helper(int[] nums){
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            int value = mp.getOrDefault(nums[i], 0);
            value += 1;
            if(value > n/2) return nums[i];
            mp.put(nums[i], value);
        }

        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            if(it.getKey() > n/2) return it.getValue();
        }

        return -1;
    }
    public int mooreAlgorithm(int[] nums) {
        int n = nums.length;
        int i = 1;
        int ele = nums[0];
        int count = 1;
        while(i < n) {
            if(nums[i] == ele) count += 1;
            else count -= 1;
            if(count == 0) {
                ele = nums[i];
                count = 1;
            }

            i++;
        }

        return ele;
    }
    public int majorityElement(int[] nums) {
        return mooreAlgorithm(nums);
    }
}
