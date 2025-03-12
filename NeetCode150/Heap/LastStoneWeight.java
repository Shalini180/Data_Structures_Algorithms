class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int it : stones) pq.add(it);
        while(pq.size() > 1){
            int top = pq.poll();
            int secondTop = pq.poll();
            int diff = top - secondTop;
            if(diff > 0) pq.offer(diff);
        }
        if(pq.size() == 0) return 0;
        
        return pq.poll();
    }
}
