long countTriplets(int n, int sum, long a[]) {
        Arrays.sort(a);
        long s = 0;
        for(int first = 0; first < n - 2; first++){
            int i = first + 1;
            int j = n - 1;
            while(i < j){
                long diff = sum - a[first] - a[i] - a[j];
                if(diff > 0) {
                    s += (j - i);
                    i++;
                }
                else j--;
            }
        }
        
        return s;
    }
