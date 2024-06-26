class Solution {
    public List<List<Integer>> subsetHelper(int[] nums, int i){
        if(i == nums.length){
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }

        List<List<Integer>> partialAns = subsetHelper(nums, i+1);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> var : partialAns){
            ans.add(new ArrayList<>(var));
        }

        for(List<Integer> var : partialAns){
            List<Integer> subset = new ArrayList<>(var);
            subset.add(nums[i]);
            ans.add(subset);
        }

        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return subsetHelper(nums, 0);
    }
}
