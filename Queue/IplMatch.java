class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(j < n){
            int ele = arr[j];
            
            while(q.size() > 0 && arr[q.peekLast()] <= ele){
                q.removeLast();
            }
            q.addLast(j);
            
            if(j - i + 1 < k) j++;
            else{
                ans.add(arr[q.peekFirst()]);
                
                if(i >= q.peekFirst()){
                    while(q.size() > 0 && i >= q.peekFirst()) q.removeFirst();
                }
                
                i++;j++;
            }
        }
        
        return ans;
    }
}
