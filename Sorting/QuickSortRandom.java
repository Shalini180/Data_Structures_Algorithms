class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if (low >= high)
            return;

        int id = partition(arr, low, high);
        quickSort(arr, low, id - 1);
        quickSort(arr, id + 1, high);
    }

    static int partition(int arr[], int low, int high) {
        int pivot_index = low + (int)(Math.random() * ((high - low) + 1));
        int temp = arr[high];
        arr[high] = arr[pivot_index];
        arr[pivot_index] = temp;
        
        int pivot = arr[high];
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot)
                small.add(arr[i]);
            else
                large.add(arr[i]);
        }

        int k = low;
        for (int i = 0; i < small.size(); i++)
            arr[k++] = small.get(i);
        arr[k++] = pivot;
        for (int i = 0; i < large.size(); i++)
            arr[k++] = large.get(i);

        return low + small.size();
    }
}
