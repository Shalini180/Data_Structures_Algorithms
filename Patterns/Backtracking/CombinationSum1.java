class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public void helper(int[] candidates, int target, int ind, int n){
        if(target == 0){
            answer.add(new ArrayList<>(temp));
        }
        if(target < 0) return;

        for(int i = ind; i < n; i++){
            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], i, n);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, candidates.length);
        return answer;
    }
}
