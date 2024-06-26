class Solution {
    public void helper(int[] nums, int i, List<Integer> temp, List<List<Integer>> ans){
        if(nums.length == i){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(nums, i+1, temp, ans);
        temp.remove(temp.size() - 1);
        helper(nums, i+1, temp, ans);
    } 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;

    }
}
