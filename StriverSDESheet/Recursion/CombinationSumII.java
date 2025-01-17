class Solution {
    public void helper(int[] a, int target, int ind, int n, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0) ans.add(new ArrayList<>(ds));

        for(int i = ind; i < n; i++){
            if(i > ind && a[i] == a[i-1]) continue;
            if(target < a[i]) break;

            ds.add(a[i]);
            helper(a, target - a[i], i + 1, n, ds, ans);
            ds.remove(ds.size() - 1);
            
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        helper(candidates, target, 0, n, new ArrayList<>(), ans);
        return ans;
    }
}
