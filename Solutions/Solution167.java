class Solution167 {
  public int[] twoSum(int[] numbers, int target) {
    int[] summationIndices = new int[2];

    // First add all numbers to a set so that we can see if a number exists in O(1) time
    // but... we can only use constant space --> Not going to work

    // For every number at i, search for the number we need (target - numbers[i]) using
    // binary search.

    for (int firstSumNumberIndex = 0; firstSumNumberIndex < numbers.length; firstSumNumberIndex++) {
      int targetSecondNumber = target - numbers[firstSumNumberIndex];
      int targetSecondNumberIndex = -1;

      // Binary search on the corresponding side
      if (targetSecondNumber == numbers[firstSumNumberIndex]) {
        // Both numbers are equal
        if (firstSumNumberIndex > 0 && numbers[firstSumNumberIndex - 1] == targetSecondNumber) {
          summationIndices[0] = firstSumNumberIndex + 1;
          summationIndices[1] = firstSumNumberIndex;
          return summationIndices;
        } else {
          summationIndices[0] = firstSumNumberIndex + 1;
          summationIndices[1] = firstSumNumberIndex + 2;
          return summationIndices;
        }
      } else if (targetSecondNumber > numbers[firstSumNumberIndex]) {
        // The second number is larger
        targetSecondNumberIndex =
            binarySearch(numbers, firstSumNumberIndex + 1, numbers.length - 1, targetSecondNumber);
      } else {
        // The second number is smaller
        targetSecondNumberIndex =
            binarySearch(numbers, 0, firstSumNumberIndex - 1, targetSecondNumber);
      }
      if (targetSecondNumberIndex == -1) {
        continue;
      } else {
        summationIndices[0] = firstSumNumberIndex + 1;
        summationIndices[1] = targetSecondNumberIndex + 1;
        break;
      }
    }

    return summationIndices;
  }

  public static int binarySearch(int[] numbers, int left, int right, int search) {
    int mid = left + (right - left) / 2;
    if (right < left) return -1;
    else if (numbers[mid] == search) return mid;
    else if (numbers[mid] < search) return binarySearch(numbers, mid + 1, right, search);
    else return binarySearch(numbers, left, mid - 1, search);
  }
}
