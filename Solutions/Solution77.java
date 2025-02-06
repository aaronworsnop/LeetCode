class Solution {
    private List<List<Integer>> combinations = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        createCombinations(n, k, 1, new ArrayList<>());
        return combinations;
    }

    /**
     * @param int n
     * The number to choose from
     *
     * @param int c
     * The number of elements left to choose
     *
     * @param int i
     * The current number we are considering to add to a combination
     * 
     * @param List<Integer> current
     * The current combination we are building
     */
    private void createCombinations(int n, int c, int i, List<Integer> current) {
        if (i > n - c + 1) {
            // This combination will not have enough numbers
            return;
        }

        if (c <= 0) {
            // Our combination is complete
            combinations.add(new ArrayList<>(current));
            return;
        } 

        current.add(i);
        createCombinations(n, c - 1, i + 1, current);
        current.removeLast();
        createCombinations(n, c, i + 1, current);
    }
}