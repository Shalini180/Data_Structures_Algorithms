class Solution {
    List<List<Integer>> ans;
    public Solution(){
        ans = new ArrayList<>();
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void addToList(int[] nums){
        List<Integer> temp = new ArrayList<>();
        for(int it : nums) temp.add(it);
        ans.add(temp);
    }
    public void helper(int index, int[] nums){
        if(index == nums.length){
            addToList(nums);
            return;
        }
        for(int i = index; i < nums.length;i++){
            swap(nums, i, index);
            helper(index+1, nums);
            swap(nums, i, index);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        helper(0, nums);
        return ans;
    }
}
