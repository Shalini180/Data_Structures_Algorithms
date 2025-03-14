class Pair {
    int value;
    int i;
    int j;
    public Pair(int value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        pq.add(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add("0,0");
        while(k-- > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            int i = curr.i, j = curr.j;
            answer.add(List.of(nums1[i], nums2[j]));
            if(i+1 < nums1.length &&  !visited.contains((i + 1) + "," + j)) {
                pq.add(new Pair(nums1[i+1] + nums2[j], i+1, j));
                visited.add((i + 1) + "," + j);
            }
            if(j+1 < nums2.length && !visited.contains(i + "," + (j + 1))){
                pq.add(new Pair(nums1[i]+nums2[j+1],i,j+1));
                visited.add(i + "," + (j + 1));
            }
        }

        return answer;
    }
}
