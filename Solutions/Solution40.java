class Solution {
    private List<List<Integer>> combinations;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Add until we get to `target` or till we spill over
        this.combinations = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        Arrays.sort(candidates);
        findCombinations(new LinkedList<>(), 0, 0);
        return combinations;
    }

    private void findCombinations(List<Integer> currentCombination, int currentSum, int candidateIndex) {
        if (currentSum > target) {
            return;
        }

        if (currentSum == target) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int index = candidateIndex; index < candidates.length; index++) {
            if (index > candidateIndex && candidates[index] == candidates[index - 1]) continue;

            currentCombination.add(candidates[index]);
            findCombinations(currentCombination, currentSum + candidates[index], index + 1);
            currentCombination.removeLast();
        }
    }
}