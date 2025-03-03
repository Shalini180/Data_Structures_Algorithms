class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int zeroes = 0;
        int maxi = 0;
        Deque<Integer> dq = new LinkedList<>();
        while(j < nums.length){
            if(nums[j] == 0){
                zeroes++;
                dq.addLast(j);
            }

            while(zeroes > k){
                    i = Math.max(dq.pollFirst() + 1, i);
                    zeroes--;
            }
            
            maxi = Math.max(maxi, j - i + 1);
            j++;
        }

        return maxi;
    }
}
