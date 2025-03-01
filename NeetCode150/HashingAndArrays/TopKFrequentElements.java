import java.util.*;

class Pair implements Comparable<Pair> {  // Pair must implement Comparable for PriorityQueue sorting
    Integer freq;
    Integer val;

    public Pair(Integer freq, Integer val) {
        this.freq = freq;
        this.val = val;
    }

    @Override
    public int compareTo(Pair other) {
        return this.freq - other.freq; // Min-Heap based on frequency
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(); // Min heap based on frequency
        Map<Integer, Integer> mp = new HashMap<>();

        for (int it : nums) {
            mp.put(it, mp.getOrDefault(it, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            minHeap.add(new Pair(it.getValue(), it.getKey()));
            if (minHeap.size() > k) minHeap.poll();
        }

        int[] ans = new int[k];
        while (!minHeap.isEmpty()) {
            ans[--k] = minHeap.poll().val;
        }

        return ans;
    }
}
