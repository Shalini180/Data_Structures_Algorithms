class Solution {
    List<List<Integer>> ans;
    public Solution(){
        ans = new ArrayList<>();
    }
    public void helper(int[] a, int target, int i, List<Integer> temp){
        if(i == a.length){
            if(target == 0) ans.add(new ArrayList<>(temp));
            return;
        }

        //Pick
        if(a[i] <= target) {
            temp.add(a[i]);
            helper(a, target - a[i], i , temp);
            temp.remove(temp.size() - 1);
        }
        
        helper(a, target, i + 1, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, 0, temp);
        return ans;
    }
}
