class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < n - 3; first++) {
            // Skip duplicates for the first pointer
            if (first > 0 && nums[first] == nums[first - 1]) continue;

            for (int second = first + 1; second < n - 2; second++) {
                // Skip duplicates for the second pointer
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;

                int third = second + 1;
                int fourth = n - 1;

                while (third < fourth) {
                    // Use long to prevent overflow
                    long sum = (long) nums[first] + nums[second] + nums[third] + nums[fourth];

                    if (sum == target) {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));

                        // Move `third` pointer to avoid duplicates
                        while (third < fourth && nums[third] == nums[third + 1]) third++;

                        // Move `fourth` pointer to avoid duplicates
                        while (third < fourth && nums[fourth] == nums[fourth - 1]) fourth--;

                        // Move both pointers after finding a valid quadruplet
                        third++;
                        fourth--;
                    } else if (sum < target) {
                        third++;
                    } else {
                        fourth--;
                    }
                }
            }
        }

        return ans;
    }
}
