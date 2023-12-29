class Solution78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, 0, ans, new ArrayList<>());
    return ans;
  }

  private void backtrack(
      int[] nums, int decision, List<List<Integer>> ans, List<Integer> currentSubset) {
    if (decision == nums.length) {
      List<Integer> subset = new ArrayList<>(currentSubset);
      ans.add(subset);
      return;
    }

    backtrack(nums, decision + 1, ans, currentSubset);

    currentSubset.add(nums[decision]);
    backtrack(nums, decision + 1, ans, currentSubset);
    currentSubset.remove(currentSubset.size() - 1);
  }
}
