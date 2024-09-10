class Solution {
    Integer calculateNCR(int n, int r){
        int ans = 1;
        for(int i = 0;i < r;i++){
            ans = ans * (n-i);
            ans = ans/(i+1);
        }

        return ans;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i < numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                temp.add(calculateNCR(i, j));
            }

            ans.add(temp);
        }

        return ans;
    }
}
