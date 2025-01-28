class Solution {
    public List<List<Integer>> helper(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue; // Skip duplicates for the first element

            int i = first + 1, j = n - 1;
            while (i < j) {
                long sum = nums[first] + nums[i] + nums[j];
                if (sum == 0L) {
                    ans.add(Arrays.asList(nums[first], nums[i], nums[j])); // Add triplet to the result
                    i++;
                    j--;
                    // Skip duplicates for the second and third elements
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        return helper(nums);
    }
}
