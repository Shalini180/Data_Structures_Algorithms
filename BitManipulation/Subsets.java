class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for(int m = 0; m < (1 << n); m++){
            List<Integer> curr = new ArrayList<>();
            for(int i = 0;i < n;i++){
                if(((m >> i) & 1) == 1) curr.add(nums[i]);
            }

            ans.add(curr);
        }

        return ans;
    }
}
