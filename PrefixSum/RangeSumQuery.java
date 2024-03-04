class NumArray {
    ArrayList<Integer> prefixSum;
    public NumArray(int[] nums) {
        prefixSum = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int ans = (i == 0) ? nums[i] : prefixSum.get(i-1) + nums[i];
            prefixSum.add(ans);
        }
        
    }
    
    public int sumRange(int left, int right) {
        int prefixSumRight = prefixSum.get(right);
        int prefixSumLeft = (left == 0) ? 0 : prefixSum.get(left - 1);
        return prefixSumRight - prefixSumLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
