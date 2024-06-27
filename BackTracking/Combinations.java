class Solution {
    public void helper(int i, int n, int k, List<Integer> temp, List<List<Integer>> ans) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (i > n) return;

        for (int j = i; j <= n; j++) {
            temp.add(j);
            helper(j + 1, n, k, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), ans);
        return ans;
    }
}
