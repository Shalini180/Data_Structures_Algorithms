class Pair {
    int value;
    int arrayIndex;
    int elementIndex;
    public Pair(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);
        for(int i = 0; i < matrix.length;i++){
            if(matrix[i].length > 0) pq.add(new Pair(matrix[i][0], i, 0));
        }

        while(k-- > 1) {
            Pair curr = pq.poll();
            if(curr.elementIndex + 1  < matrix[curr.arrayIndex].length){
                pq.add(new Pair(matrix[curr.arrayIndex][curr.elementIndex + 1], curr.arrayIndex, curr.elementIndex + 1));
            }
        }

        return pq.poll().value;
    }
}
