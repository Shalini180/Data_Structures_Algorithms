class Solution {
    public void dfs(int[] nums, List<Integer> current, List<List<Integer>> result, int ind){
        result.add(new ArrayList<>(current));

        for(int i = ind; i < nums.length;i++){
            current.add(nums[i]);
            dfs(nums, current, result, i + 1);
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> powerSet(int[] nums){
        int n = nums.length;
        int total = 1 << n;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<total;i++){
            List<Integer> subset = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((i & (1 << j)) != 0) subset.add(nums[j]);
            }

            result.add(subset);
        }

        return result;
    }
    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> result = new ArrayList<>();
        // dfs(nums, new ArrayList<>(), result, 0);
        // return result;

        return powerSet(nums);
    }
}
