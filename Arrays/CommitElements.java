class Solution {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while (i < n1 && j < n2 && k < n3) {
            if (A[i] == B[j] && B[j] == C[k]) {
                ans.add(A[i]);
                int ele = A[i];
                while (i < n1 && A[i] == ele)
                    i++;
                while (j < n2 && B[j] == ele)
                    j++;
                while (k < n3 && C[k] == ele)
                    k++;
            } else if (A[i] <= B[j] && A[i] <= C[k]) {
                i++;
            } else if (B[j] <= A[i] && B[j] <= C[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        return ans;
    }
}
