class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public void helper(int[] a, int target, int ind, int n) {
        if(target == 0) answer.add(new ArrayList<>(temp));
        if(target < 0) return;

        for(int i = ind; i < n; i++){
            if(i > ind && a[i] == a[i-1]) continue;

            temp.add(a[i]);
            helper(a, target - a[i], i + 1, n);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, candidates.length);
        return answer;
    }
}
