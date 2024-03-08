class Solution1470 {
  public int[] shuffle(int[] nums, int n) {
    int[] toReturn = new int[n * 2];
    for (int i = 0; i < n; i++) {
      toReturn[i * 2] = nums[i];
      toReturn[i * 2 + 1] = nums[n + i];
    }
    return toReturn;
  }
}
