class Solution {
    public List<Integer> generateRow(int n){
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(n == 1) return ans;

        int curr = 1;
        for(int i = 1; i < n - 1; i++){
            curr = curr * (n-i);
            curr = curr/i;
            ans.add(curr);
        }

        ans.add(1);

        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= numRows;i++){
            List<Integer> temp = generateRow(i);
            ans.add(temp);
        }

        return ans;
    }
}
