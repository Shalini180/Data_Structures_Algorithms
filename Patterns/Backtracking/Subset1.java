class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public void helper(int[] nums, int ind) {
        answer.add(new ArrayList<>(temp));


        for(int i = ind; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0);
        return answer;
    }
}
