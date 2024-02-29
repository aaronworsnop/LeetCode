class Solution384 {
  int[] original;
  int[] array;

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
    Random rand = new Random();
    for (int i = 0; i < array.length; i++) {
      int swapIndex = rand.nextInt(array.length);
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
