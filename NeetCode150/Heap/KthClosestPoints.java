class Points implements Comparable<Points>{
    int x;
    int y;
    int dist;
    public Points(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Points other){
        return other.dist - this.dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> pq = new PriorityQueue<>();
        for(int[] point : points){
            pq.add(new Points(point[0], point[1], point[0]*point[0] + point[1]*point[1]));
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        while(pq.size() > 0) {
            ans[k-1][0] = pq.peek().x;
            ans[k-1][1] = pq.peek().y;
            k-=1;
            pq.poll();
        }

        return ans;
    }
}
