class Solution{
    static int deno[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
    static List<Integer> minPartition(int N)
    {
        List<Integer> answer = new ArrayList<>();
        int j = deno.length - 1;
        while(j >= 0 && N > 0){
            if(deno[j] > N) j--;
            else if(deno[j] <= N){
                answer.add(deno[j]);
                N-= deno[j];
            }
        }
        
        return answer;
    }
}
