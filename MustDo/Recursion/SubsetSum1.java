class Solution{
    void subsetHelper(ArrayList<Integer> arr, int N, int i, int sum, ArrayList<Integer> ans){
        if(i == N){
            ans.add(sum);
            return;
        }
        
        subsetHelper(arr, N, i + 1, sum + arr.get(i), ans);
        subsetHelper(arr, N, i + 1, sum, ans);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        subsetHelper(arr, N, 0, 0, ans);
        return ans;
        
    }
}
