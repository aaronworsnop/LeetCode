class Solution2824 {
  public int countPairs(List<Integer> nums, int target) {
    // Edgecase
    if (nums == null || nums.isEmpty()) {
      throw new IllegalArgumentException("`nums` must contain elements");
    }

    // Determine how pairs' sum are under our `target` threshold
    int validPairs = 0;

    for (int firstIndex = 0; firstIndex < nums.size(); firstIndex++) {
      for (int secondIndex = firstIndex + 1; secondIndex < nums.size(); secondIndex++) {
        if (nums.get(firstIndex) + nums.get(secondIndex) < target) {
          validPairs++;
        }
      }
    }

    return validPairs;
  }
}
