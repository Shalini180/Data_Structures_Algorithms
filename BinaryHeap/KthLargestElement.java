class Solution {
    public int helper(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int it : nums){
            pq.add(it);
            if(pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, k);
    }
}
