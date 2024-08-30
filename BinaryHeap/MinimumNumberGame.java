class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int it : nums){
            minHeap.add(it);
        }
        
        int i = 0;
        int[] ans = new int[nums.length];
        while(minHeap.size() > 0){
            int second = minHeap.poll();
            int first = minHeap.poll();
            ans[i] = first;
            ans[i+1] = second;
            i+=2;
        }

        return ans;
    }
}
