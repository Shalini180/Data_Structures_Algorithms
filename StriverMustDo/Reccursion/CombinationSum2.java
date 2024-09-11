class Solution {
    List<List<Integer>> ans;
    public Solution(){
        ans = new ArrayList<>();
    }
    public void helper(int[] a, int target, int i, List<Integer> temp){
       if(target == 0) {
                ans.add(new ArrayList<>(temp));
        }
        
        for(int j = i; j < a.length; j++){
            if(j > i && a[j] == a[j - 1]) continue;
            if(a[j] > target) break;

            temp.add(a[j]);
            helper(a, target - a[j], j + 1, temp);
            temp.remove(temp.size() - 1);
        }
    
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, 0, temp);
        return ans;
    }
}
