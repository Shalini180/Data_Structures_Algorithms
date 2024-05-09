class RecentCounter {
    Queue<Integer> q ;
    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        q.add(t);
        int lowerBound = t - 3000;
        Iterator<Integer> it = q.iterator();
        int ans = 0;
        while(it.hasNext()){
            int ele = it.next();
            if(ele >= lowerBound && ele <= t){
                ans += 1;
            }
        }

        return ans;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
