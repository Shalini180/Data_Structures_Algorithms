class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < n - 2; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            
            int second = first + 1;
            int third = n - 1;
            
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while (second < third && nums[second] == nums[second + 1]) second++;
                    while (second < third && nums[third] == nums[third - 1]) third--;
                    second++;
                    third--;
                } else if (sum < 0) {
                    second++;
                } else {
                    third--;
                }
            }
        }
        
        return ans;
    }
}
