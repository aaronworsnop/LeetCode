class Solution78 {
  public List<List<Integer>> subsets(int[] nums) {
    // This is a backtracking problem
    List<List<Integer>> subsets = new ArrayList<>();
    backtrack(subsets, nums, new ArrayList<>(), 0);
    return subsets;
  }

  private void backtrack(
      List<List<Integer>> subsets, int[] nums, List<Integer> currentSubset, int decision) {
    if (decision >= nums.length) {
      subsets.add(new ArrayList<>(currentSubset));
      return;
    }

    currentSubset.add(nums[decision]);
    backtrack(subsets, nums, currentSubset, decision + 1);

    currentSubset.remove(currentSubset.size() - 1);
    backtrack(subsets, nums, currentSubset, decision + 1);
  }
}
