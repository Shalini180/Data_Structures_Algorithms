class Solution {
    public List<Integer> generateRow(int n){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        int res = 1;
        for(int i = 1; i < n; i++){
            res = res * (n - i);
            res = res / i;
            ans.add(res);
        }

        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            result.add(generateRow(i));
        }

        return result;
    }
}
