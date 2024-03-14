class Solution {
    // Function to sort the array using insertion sort algorithm.
    public void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int nums = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > nums)
                    arr[j + 1] = arr[j];
                else
                    break;
                j--;
            }
            arr[j + 1] = nums;
        }
    }
}
