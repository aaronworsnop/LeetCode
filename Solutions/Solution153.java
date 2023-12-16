class Solution153 {
  public int findMin(int[] nums) {
    // This is just a binary search that looks for the element with a larger element to its left

    int result = nums[0];

    int left = 0;
    int right = nums.length - 1;
    int mid = 0;

    // [1, 2, 3, 4, 88]
    // [88, 1, 2, 3, 4]
    // [4, 88, 1, 2, 3]
    // [3, 4, 88, 1, 2]
    // [2, 3, 4, 88, 1]

    while (left <= right) {
      if (nums[left] < nums[right]) {
        result = Math.min(result, nums[left]);
        break;
      }

      mid = left + (right - left) / 2;
      result = Math.min(result, nums[mid]);

      if (nums[mid] >= nums[left]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return result;
  }
}
