class Solution {
    public int rightShiftHelper(int n){
        int count = 0;
        while(n > 0){
            if((n & 1) == 1) count++;
            n = n >> 1;
        }

        return count;
    }
    public int helper(int n) {
        int count = 0;
        while(n > 0){
            n = n & (n-1);
            count++;
        }

        return count;
    }
    public int hammingWeight(int n) {
        // return helper(n);
        return rightShiftHelper(n);
    }
}
