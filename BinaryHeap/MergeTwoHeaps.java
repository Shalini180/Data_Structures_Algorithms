class Solution{
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void heapify(int[] a, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < n && a[left] > a[largest]) largest = left;
        if(right < n && a[right] > a[largest]) largest = right;
        if(largest != i){
            swap(a, largest, i);
            heapify(a, n, largest);
        }
    }
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] ans = new int[n + m];
        for(int i = 0;i < n; i++) ans[i] = a[i];
        for(int i = 0;i < m; i++) ans[i + n] = b[i];
        int totalSize = n + m;
        for(int i = (totalSize/2) - 1; i >= 0;i--) heapify(ans, totalSize, i);
        return ans;
    }
}
