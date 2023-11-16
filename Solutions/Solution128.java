class Solution128 {
  public int longestConsecutive(int[] nums) {
    // Initial thoughts, add everything to priority queue
    // Then pop and count how many are consecutive

    // Edgecase
    if (nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return 1;
    }

    int maxCon = 1;

    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int start = num;
        while (set.contains(num++)) {
          maxCon = Math.max(num - start, maxCon);
        }
      }
    }

    return maxCon;
  }
}
