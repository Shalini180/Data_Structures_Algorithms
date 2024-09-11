class Solution {
    List<List<Integer>> ans;
    public Solution(){
        ans = new ArrayList<>();
    }

    public void helper(int[] nums, int i, List<Integer> temp){
        ans.add(new ArrayList<>(temp));
        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }

            temp.add(nums[j]);
            helper(nums, j+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(nums, 0, temp);
        return ans;
    }
}
