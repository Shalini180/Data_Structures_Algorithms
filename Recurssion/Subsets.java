class Solution {
    public void generateSubsets(int[] nums, int index, List<List<Integer>> result, List<Integer> currentSubset) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset)); // Add a copy of currentSubset to result
            return;
        }

        // Include current element
        currentSubset.add(nums[index]);
        generateSubsets(nums, index + 1, result, currentSubset);

        // Exclude current element
        currentSubset.remove(currentSubset.size() - 1);
        generateSubsets(nums, index + 1, result, currentSubset);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        generateSubsets(nums, 0, result, currentSubset);
        return result;
    }
}
