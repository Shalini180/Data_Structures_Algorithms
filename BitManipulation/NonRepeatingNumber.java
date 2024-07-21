class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int xor = 0;
        for(int a : nums) xor = xor ^ a;
        int lastSetBit = 0;
        int cnt = 0;
        while(xor > 0){
            if((xor & 1) == 1){
                lastSetBit = cnt;
                break;
            }
            
            cnt++;
            xor = xor >> 1;
        }
        
        int first = 0;
        int second = 0;
        int threshold = 1 << lastSetBit;
        for(int i = 0;i<nums.length;i++){
            if((nums[i] & threshold) == 0) first = first ^ nums[i];
            else second = second ^ nums[i];
        }
        
        int[] ans = new int[2];
        ans[0] = Math.min(first, second);
        ans[1] = Math.max(first, second);
        
        return ans;
    }
}
