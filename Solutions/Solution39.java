class Solution39 {
  private List<List<Integer>> combinations;
  private int[] candidates;
  private int target;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // `candidates[]` is an integer array
    // `target` is an integer
    // Goal: return all UNIQUE combinations that sum to the target
    // [1, 1, 3], x-[3, 1, 1]-x | 5

    // 2 <= `candidate[i]` <= 40
    // 1 <= `candidates.length` <= 30
    // 1 <= `target` <= 40
    // return `<List<List<Integer>>` in any order

    // No combinations, return empty `<List<List<Integer>>`

    // candidates: [1, 2] | target: 4
    // combinations: [[1, 1, 1, 1], [1, 1, 2], [2, 2]]

    //      /\
    //     1  2
    //   1 2  1 2
    // 12 12 12 12

    // currentCombo: [1, 2, 1] -> This equals the target! Add to our final `combinations` list.
    // Also, add to a set to ensure
    // we aren't generating duplicates, which will allows us to check for duplicates in O(1) rather
    // than O(n) at the cost of
    // little memory in this situation.

    // currentCombo: [2, 2, 2] -> This is greater than the target, no more hope. Break out of the
    // branch

    // Testcases
    // candidates: [], target: 20 | SUCCESS
    // candidates: [1], target: 20
    // candidates: [2, 3, 4], target: 4

    // START

    // Initialise global variables
    this.combinations = new LinkedList<>();
    this.candidates = candidates;
    this.target = target;

    // Edge and known cases
    if (candidates.length == 0) {
      return combinations;
    }

    findCombinations(new LinkedList<>(), 0, 0);

    return combinations;
  }

  /** Generate all combinations unique combinations */
  private void findCombinations(
      List<Integer> currentCombination, int candidateIndex, int currentSum) {
    if (currentSum == target) {
      combinations.add(new LinkedList<Integer>(currentCombination));
    }

    if (currentSum > target) {
      return;
    }

    for (int index = candidateIndex; index < candidates.length; index++) {
      int candidate = candidates[index];
      currentCombination.add(candidate);
      findCombinations(currentCombination, index, currentSum + candidate);
      currentCombination.remove(currentCombination.size() - 1);
    }

    return;
  }
}
