class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];
        Arrays.fill(population, 0);
        for (int i = 0; i < logs.length; i++) {
            int birth = logs[i][0] - 1950;
            int death = logs[i][1] - 1950;
            population[birth] += 1;
            population[death] -= 1;
        }

        int maxPopulation = Integer.MIN_VALUE, index = -1, pick = 0;
        for (int i = 0; i < population.length; i++) {
            if (population[i] != 0)
                pick += population[i];
            if (maxPopulation < pick)
                index = i;
            maxPopulation = Math.max(maxPopulation, pick);
        }

        return index + 1950;
    }
}
