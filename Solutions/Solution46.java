class Solution46 {
  public List<List<Integer>> permute(int[] nums) {
    // Edgecases
    if (nums.length == 0) {
      List<Integer> inner = new ArrayList<>();
      List<List<Integer>> outer = new ArrayList<>();
      outer.add(inner);
      return outer;
    }
    if (nums.length == 1) {
      List<Integer> inner = new ArrayList<>();
      inner.add(nums[0]);
      List<List<Integer>> outer = new ArrayList<>();
      outer.add(inner);
      return outer;
    }

    List<List<Integer>> permutations = new ArrayList<>();
    backtrack(permutations, nums, new ArrayList<Integer>(), nums.length);
    return permutations;
  }

  public void backtrack(
      List<List<Integer>> permutations, int[] available, List<Integer> currentList, int size) {
    if (currentList.size() == size) {
      permutations.add(currentList);
      return;
    }

    // Backtracking
    int currentNum = 0;
    for (int num : available) {
      // Adding a digit
      currentList.add(num);

      // Adjusting the available digits
      int[] availableLeft = new int[available.length - 1];
      for (int i = 0; i < availableLeft.length; i++) {
        if (i < currentNum) {
          availableLeft[i] = available[i];
        } else {
          availableLeft[i] = available[i + 1];
        }
      }

      List<Integer> newList = new ArrayList<>(currentList);
      backtrack(permutations, availableLeft, newList, size);
      currentList.remove(currentList.size() - 1);
      currentNum++;
    }
  }
}
