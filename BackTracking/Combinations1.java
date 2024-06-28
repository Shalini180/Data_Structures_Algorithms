class Solution {
    public void helper(int i, int[] candidates, int target, int sum, List<List<Integer>> ans, List<Integer> temp) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            temp.add(candidates[j]);
            helper(j, candidates, target, sum + candidates[j], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }
}
