class Solution {
    public void helper(int[] nums, int ind, int n, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = ind; i < n; i++) {
            if(i > ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            helper(nums, i+1, n, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, nums.length, new ArrayList<>(), ans);
        return ans;
    }
}
