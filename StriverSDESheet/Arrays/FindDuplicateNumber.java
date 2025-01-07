class Solution {
    public int hashing(int[] nums){
        int n = nums.length;
        int[] hash = new int[n+1];
        for(int it : nums) {
            if(hash[it] > 0) return it;
            hash[it] = 1;
        }

        return -1;
    }
    public int tortaiseHare(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
    
    public int findDuplicate(int[] nums) {
        return tortaiseHare(nums);
    }
}
