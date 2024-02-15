class Solution324 {
  public void wiggleSort(int[] nums) {
    // Edgecases
    if (nums == null || nums.length == 0) {
      return;
    }

    // Sort the array, we only have 5,001 distinct elements
    // so we can do counting sort
    int[] numsSorted = new int[nums.length];
    int[] numFrequencies = new int[5001];
    for (int num = 0; num < nums.length; num++) {
      numFrequencies[nums[num]]++;
    }

    int numsIndex = 0, numFrequency = 0;
    while (numsIndex < nums.length) {
      if (numFrequencies[numFrequency] > 0) {
        for (int count = 0; count < numFrequencies[numFrequency]; count++) {
          numsSorted[numsIndex++] = numFrequency;
        }
      }
      numFrequency++;
    }

    // 1, 3, 4, 4, 6, 6
    //       ^        ^
    numsIndex = 0;
    int right = nums.length - 1;
    int left = right / 2;
    while (numsIndex < nums.length) {
      if (numsIndex % 2 == 0) {
        nums[numsIndex++] = numsSorted[left--];
      } else {
        nums[numsIndex++] = numsSorted[right--];
      }
    }
  }
}
