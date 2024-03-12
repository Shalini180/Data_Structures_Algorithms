class Solution{
    public void patternHelper(int N,int add, List<Integer> ans, int temp){
        if(N <= 0){
            ans.add(N);
            return;
        }
        
        
        ans.add(N);
        patternHelper(N-5,add,ans,temp);
        ans.add(N);
    }
    public List<Integer> pattern(int N){
        List<Integer> ans = new ArrayList<>();
        patternHelper(N, -5, ans, N);
        return ans;
    }
}
