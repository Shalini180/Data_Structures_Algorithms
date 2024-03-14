class Compute {
    
    public long[] printFirstNegativeInteger(long array[], int size, int windowSize) {
        long[] result = new long[size - windowSize + 1];
        Deque<Long> deque = new LinkedList<>();
        int start = 0, end = 0, index = 0;
        while (end < size) {
            if (array[end] < 0)
                deque.addLast(array[end]);
            
            if (end - start + 1 < windowSize)
                end++;
            else if (end - start + 1 == windowSize) {
                Long firstNegative = deque.peekFirst();
                if (firstNegative == null)
                    result[index] = 0;
                else
                    result[index] = firstNegative;
                index++;
                if (firstNegative != null && firstNegative.equals(array[start])) {
                    deque.pollFirst();
                }
                start++;
                end++;
            }
        }
        return result;
    }
}
