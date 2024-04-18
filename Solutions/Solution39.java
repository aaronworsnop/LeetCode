class Solution39 {
  List<List<Integer>> combinations = new ArrayList<>();

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

    // Edge and known cases
    if (candidates.length == 0) {
      return combinations;
    }

    findCombinations(candidates, 0, target, new ArrayList<>());
    return combinations;
  }

  public void findCombinations(
      int[] candidates, int candidateIndex, int target, List<Integer> currentCombination) {
    if (target == 0) {
      combinations.add(new ArrayList<>(currentCombination));
      return;
    }

    if (target < 0 || candidateIndex >= candidates.length) {
      return;
    }

    for (int index = candidateIndex; index < candidates.length; index++) {
      currentCombination.add(candidates[index]);
      findCombinations(candidates, index, target - candidates[index], currentCombination);
      currentCombination.remove(currentCombination.size() - 1);
    }
  }
}
