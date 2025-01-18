class Solution {
    int find(int[][] a, int ind, int n){
        int ans = a[0][ind];
        for(int i = 1; i < n;i++){
            if(ind == 0){
                ans = Integer.min(a[i][ind], ans);
            }
            else{
                ans = Integer.max(a[i][ind], ans);
            }
        }
        
        return ans;
    }
    int calculateSmallestEle(int[][] matrix, int ele){
        int c = 0;
        for(int[] temp : matrix){
            c += upperBound(temp, ele);
        }
        
        return c;
    }
    int upperBound(int[] a, int ele){
        int low = 0;
        int high = a.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(a[mid] <= ele) low = mid + 1;
            else high = mid - 1;
        }
        
        return low;
    }
    int helper(int matrix[][], int n, int m){
        int low = find(matrix, 0, n);
        int high = find(matrix, m-1, n);
        while(low <= high){
            int mid = (low + high)/2;
            int smallestEle = calculateSmallestEle(matrix, mid);
            if(smallestEle <= (n*m)/2){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return low;
    }
    int median(int matrix[][]) {
        return helper(matrix, matrix.length, matrix[0].length);
    }
}
