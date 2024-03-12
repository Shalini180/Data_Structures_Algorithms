class Solution {
   final int mod = 1000000007;
    ArrayList<Long> helper(int n){
        if(n == 1){
            ArrayList<Long> temp = new ArrayList<>();
            temp.add(1L);
            return temp;
        }
        
        ArrayList<Long> prev = helper(n-1);
        ArrayList<Long> cur = new ArrayList<>();
        cur.add(1L);
        for(int i = 1;i<n-1;i++){
            long ans = (prev.get(i) + prev.get(i-1))%mod;
            cur.add(ans);
        }
        cur.add(1L);
        return cur;
    }
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        return helper(n);
    }
}
