class Solution53 {
  public int maxSubArray(int[] nums) {

    // Edgecases
    if (nums.length == 0) {
      return 0;
    }

    // Initialise varaibles
    int leftPointer = 0, rightPointer = 0;
    int currentSum = nums[0], maxSum = nums[0], previousMaxPosition;

    while (true) {
      while (leftPointer < rightPointer
          && (rightPointer == nums.length - 1 || nums[leftPointer] <= 0)) {
        // If moving the start of the sub-array forward can increase
        // our current sum, do it.
        currentSum -= nums[leftPointer];
        leftPointer++;
        maxSum = Math.max(maxSum, currentSum);
      }

      rightPointer++;
      if (rightPointer == nums.length) {
        break;
      }

      // If the current number is greater than the current sum, then
      // we can start a new sub-array from this point.
      currentSum += nums[rightPointer];
      if (nums[rightPointer] > currentSum) {
        leftPointer = rightPointer;
        currentSum = nums[rightPointer];
      }

      maxSum = Math.max(maxSum, currentSum);
    }

    System.out.println("Left: " + leftPointer + ", Right: " + rightPointer);

    return maxSum;
  }
}
