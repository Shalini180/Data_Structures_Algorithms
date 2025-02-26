class Solution {
    public void helper(int[] a, int target, List<List<Integer>> ans, List<Integer> temp, int ind){
        if(target < 0 || ind == a.length) return;
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(a[ind]);
        helper(a, target - a[ind], ans, temp, ind);
        temp.remove(temp.size() - 1);
        helper(a, target, ans, temp, ind + 1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
}
