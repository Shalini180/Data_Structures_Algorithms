class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length, m = pattern.length, ans = 0;
        for(int i = 0;i<n;i++){
            int st = i;
            int en = i + m;
            if(en >= n) break;

            boolean flag = true;
            for(int j = 0;j<m;j++){
                if((pattern[j] == 1) && (nums[st + j + 1] <= nums[st + j])) flag = false;
                else if((pattern[j] == 0) && (nums[st + j + 1] != nums[st + j])) flag = false;
                else if((pattern[j] == -1) && (nums[st + j + 1] >= nums[st + j])) flag = false;
            }
            if(flag) ans+=1;
        }

        return ans;
    }
}
