class Solution75 {
  public void sortColors(int[] nums) {
    // red white and blue
    // can just count and replace instead of sorting.

    if (nums.length == 1) return;

    Map<Integer, Integer> colourFreq = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      colourFreq.put(nums[i], colourFreq.getOrDefault(nums[i], 0) + 1);
    }

    int red = colourFreq.getOrDefault(0, 0);
    int white = colourFreq.getOrDefault(1, 0);
    int blue = colourFreq.getOrDefault(2, 0);

    int num = 0;

    while (red != 0) {
      nums[num++] = 0;
      red--;
    }

    while (white != 0) {
      nums[num++] = 1;
      white--;
    }

    while (blue != 0) {
      nums[num++] = 2;
      blue--;
    }
  }
}
