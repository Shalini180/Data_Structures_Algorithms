class IntervalStartComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] interval1, int[] interval2) {
        return Integer.compare(interval1[1], interval2[1]);
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        IntervalStartComparator intervalComparator = new IntervalStartComparator();
        Arrays.sort(points, intervalComparator);
        int minimumArrowsNeeded = 1;
        int lastArrowPositionIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[lastArrowPositionIndex][1]) {
                minimumArrowsNeeded += 1;
                lastArrowPositionIndex = i;
            }
        }

        return minimumArrowsNeeded;
    }
}
