class Solution300 {
  public int lengthOfLIS(int[] nums) {
    // [3, 2, 1, 9, 3, 6, 2, 3, 4]
    // sorted: [1, 2, 2, 3, 3, 3, 4, 6, 9]
    // indexs: [2, 1, 6, 0, 4, 7, 8, 5, 3]
    // lii: 4
    //
    // prevMin: 3
    // when greater than `prevMin` and less than `increase`, switch
    // increase: 6
    // LIS: 3
    // [1, 3, 6] / [2, 3, 6]

    // STABLE, Sort the array, keeping track of the original indicies.
    // Run through this sorted array and count the longest sequence
    // of increasing indicies.

    // Edgecases
    if (nums == null || nums.length == 0) {
      return 0;
    } else if (nums.length == 1) {
      return 1;
    }

    // Initialise array representing the indicies of each num in nums
    int[] numsIndicies = new int[nums.length];
    for (int num = 0; num < numsIndicies.length; num++) {
      numsIndicies[num] = num;
    }

    // Sort the indicies array by the non-decreasing order of `nums`.
    // (Using a Stable MergeSort)
    sort(nums, numsIndicies, 0, numsIndicies.length - 1);

    // Count the number of increasing indicies in total
    int longestCount = 1;
    int currentNum = numsIndicies[0];
    int currentIndex = 0;
    for (int index = 1; index < numsIndicies.length; index++) {
      if (numsIndicies[index] > currentNum && nums[index] > nums[currentIndex]) {
        longestCount++;
        currentIndex = index;
        currentNum = numsIndicies[index];
      }
    }

    return longestCount;
  }

  private void sort(int[] nums, int[] numsIndicies, int left, int right) {
    if (left >= right) {
      return;
    }

    int mid = left + (right - left) / 2;
    sort(nums, numsIndicies, left, mid);
    sort(nums, numsIndicies, mid + 1, right);
    merge(nums, numsIndicies, left, mid, right);
  }

  private void merge(int[] nums, int[] numsIndicies, int left, int mid, int right) {
    int leftPoint = left;
    int rightPoint = mid + 1;
    int[] numsCopy = new int[right - left + 1];
    int[] numsIndiciesCopy = new int[right - left + 1];

    for (int current = 0; current < numsCopy.length; current++) {
      if (leftPoint > mid) {
        numsIndiciesCopy[current] = numsIndicies[rightPoint];
        numsCopy[current] = nums[rightPoint++];
      } else if (rightPoint > right) {
        numsIndiciesCopy[current] = numsIndicies[leftPoint];
        numsCopy[current] = nums[leftPoint++];
      } else if (nums[leftPoint] > nums[rightPoint]) {
        numsIndiciesCopy[current] = numsIndicies[rightPoint];
        numsCopy[current] = nums[rightPoint++];
      } else {
        numsIndiciesCopy[current] = numsIndicies[leftPoint];
        numsCopy[current] = nums[leftPoint++];
      }
    }

    for (int current = 0; current < numsCopy.length; current++) {
      nums[left + current] = numsCopy[current];
      numsIndicies[left + current] = numsIndiciesCopy[current];
    }
  }
}
