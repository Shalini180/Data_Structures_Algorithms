class Solution {
    public void helper(int[] a, int target, int n, int ind, List<Integer> ds, List<List<Integer>> ans) {
        if (ind >= n) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (target >= a[ind]) {
            ds.add(a[ind]);
            helper(a, target - a[ind], n, ind, ds, ans);
            ds.remove(ds.size() - 1);
        }

        helper(a, target, n, ind + 1, ds, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> temp = new ArrayList<>();
        helper(candidates, target, candidates.length, 0, new ArrayList<>(), temp);
        return temp;
    }
}
