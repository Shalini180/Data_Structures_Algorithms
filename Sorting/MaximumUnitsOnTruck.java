class SortComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return b[1] - a[1];
    }
}

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        SortComparator sc = new SortComparator();
        Arrays.sort(boxTypes, sc);
        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize >= boxTypes[i][0]) {
                truckSize -= boxTypes[i][0];
                ans += boxTypes[i][0] * boxTypes[i][1];
            } else {
                ans += boxTypes[i][1] * truckSize;
                break;
            }
        }
        return ans;
    }
}
