class Solution {
    private List<List<Integer>> combinations;
    private int target;
    private int k;
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.combinations = new LinkedList<>();
        this.target = n;
        this.k = k;

        findCombinations(new LinkedList<>(), 0, 1);
        return combinations;
    }

    private void findCombinations(LinkedList<Integer> currentCombination, int currentSum, int currentNumber) {
        if (currentSum > target || currentCombination.size() > k) {
            return;
        }

        if (currentSum == target && currentCombination.size() == k) {
            combinations.add(new LinkedList<>(currentCombination));
        }

        for (int number = currentNumber; number < 10; number++) {
            currentCombination.add(number);
            findCombinations(currentCombination, currentSum + number, number + 1);
            currentCombination.removeLast();
        }
    }
}
