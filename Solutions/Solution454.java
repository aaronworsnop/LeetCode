class Solution454 {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    // [1,2], [-2,-1], [-1,2], [0,2]

    // Edge and known cases
    if (nums1 == null || nums1.length == 0) {
      return 0;
    }

    int n = nums1.length;
    int count = 0;

    // Precompute the bounds at each summation step in which a sum to 0 would not be
    // possible so that we can ignore these branches when determining our final count
    int[][] maxAndMin = findBounds(nums1, nums2, nums3, nums4);

    // Try all possible combinations of elements, ignoring paths that can't possibly
    // sum to 0

    // 5, -2,
    // 3, -3,
    // 4, -1,
    // 2, 0,

    int sum;

    step1:
    for (int i = 0; i < n; i++) {
      sum = nums1[i];
      if (sum < -maxAndMin[1][0] || sum > -maxAndMin[1][1]) {
        continue step1;
      }

      step2:
      for (int j = 0; j < n; j++) {
        sum = nums1[i] + nums2[j];
        if (sum < -maxAndMin[2][0] || sum > -maxAndMin[2][1]) {
          continue step2;
        }

        step3:
        for (int k = 0; k < n; k++) {
          sum = nums1[i] + nums2[j] + nums3[k];
          if (sum < -maxAndMin[3][0] || sum > -maxAndMin[3][1]) {
            continue step3;
          }

          step4:
          for (int l = 0; l < n; l++) {
            sum = nums1[i] + nums2[j] + nums3[k] + nums4[l];
            if (sum == 0) {
              count++;
            }
          }
        }
      }
    }

    return count;
  }

  private int[][] findBounds(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    int[][] maxAndMin = new int[4][2];
    int n = nums1.length;

    // Bounds of step4
    int max = nums4[0], min = nums4[0];
    for (int l = 1; l < n; l++) {
      max = Math.max(max, nums4[l]);
      min = Math.min(min, nums4[l]);
    }
    maxAndMin[3][0] = max;
    maxAndMin[3][1] = min;

    // Bounds of step3
    max = maxAndMin[3][0] + nums3[0];
    min = maxAndMin[3][1] + nums3[0];
    for (int k = 1; k < n; k++) {
      max = Math.max(max, maxAndMin[3][0] + nums3[k]);
      min = Math.min(min, maxAndMin[3][1] + nums3[k]);
    }
    maxAndMin[2][0] = max;
    maxAndMin[2][1] = min;

    // Bounds of step2
    max = maxAndMin[2][0] + nums2[0];
    min = maxAndMin[2][1] + nums2[0];
    for (int j = 1; j < n; j++) {
      max = Math.max(max, maxAndMin[2][0] + nums2[j]);
      min = Math.min(min, maxAndMin[2][1] + nums2[j]);
    }
    maxAndMin[1][0] = max;
    maxAndMin[1][1] = min;

    // Bounds of step1
    max = maxAndMin[1][0] + nums1[0];
    min = maxAndMin[1][1] + nums1[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, maxAndMin[1][0] + nums1[i]);
      min = Math.min(min, maxAndMin[1][1] + nums1[i]);
    }
    maxAndMin[0][0] = max;
    maxAndMin[0][1] = min;

    return maxAndMin;
  }
}
