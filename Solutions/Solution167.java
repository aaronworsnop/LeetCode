class Solution167 {
  public int[] twoSum(int[] numbers, int target) {
    // Initialise pointers and working sum
    int leftIndex = 0;
    int rightIndex = numbers.length - 1;
    int currentSum = numbers[leftIndex] + numbers[rightIndex];

    // Initialise answer array
    int[] targetSumIndices = new int[2];
    targetSumIndices[0] = leftIndex + 1;
    targetSumIndices[1] = rightIndex + 1;

    // Move pointer until our working sum equals the target
    while (currentSum != target) {
      // Update working sum
      currentSum = numbers[leftIndex] + numbers[rightIndex];

      if (currentSum < target) {
        leftIndex++;
      } else if (currentSum > target) {
        rightIndex--;
      } else {
        targetSumIndices[0] = leftIndex + 1;
        targetSumIndices[1] = rightIndex + 1;
      }
    }

    return targetSumIndices;
  }
}
