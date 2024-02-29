class Solution384 {
  private int[] original;
  private int[] array;

  Random random = new Random();

  public Solution(int[] nums) {
    this.original = new int[nums.length];
    this.array = nums;

    for (int i = 0; i < nums.length; i++) {
      this.original[i] = nums[i];
    }
  }

  public int[] reset() {
    return original;
  }

  public int[] shuffle() {
    // Swap every element with a new spot
    for (int i = 0; i < array.length; i++) {
      int swapIndex = i + random.nextInt(array.length - i);
      swap(array, i, swapIndex);
    }
    return array;
  }

  private void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset(); int[] param_2 = obj.shuffle();
 */
