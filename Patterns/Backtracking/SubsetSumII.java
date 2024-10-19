class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public void helper(int[] nums, int ind) {
        ans.add(new ArrayList<>(temp));

        for(int i = ind; i < nums.length; i++) {
            if(i > ind && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            helper(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0);
        return ans;
    }
}
