class Solution33 {
  public int search(int[] nums, int target) {
    // no repeated values, [1, 2, 4, 7, 8]
    // rotation means that the numbers
    // get cut off from the beginning then put at the end of
    // rotate around index 3 -> [7, 8, 1, 2, 4]

    // The trivial solution would be to just go through
    // all of the elements in n and then check for the
    // target.

    // We have an advantage since the array is sorted though.
    // Consider n before the rotation. if target is 100, we know
    // that's not in n because 100 > n[n.length - 1]. Same for
    // the small numbers.

    // We can still do this, we just need to shift our start and end
    // to the point of rotation. We can do this by first finding
    // where the rotation is, where n[k] < n[k - 1] after the rotation.

    // After the rotation we can perform a binary search

    // Edgcases
    if (nums == null || nums.length == 0) {
      return -1;
    }

    // Find the pivot point, defined where the break caused by rotation exists
    // Synonymous with smallest value, i - 1 is largest value.
    int pivotPoint = 0;
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    pivotPoint = left;

    if (pivotPoint != 0) {
      // Has been rotated
      if (target < nums[pivotPoint] || target > nums[pivotPoint - 1]) {
        return -1;
      } else {
        int leftSide = binarySearch(nums, target, 0, pivotPoint - 1);
        int rightSide = binarySearch(nums, target, pivotPoint, nums.length - 1);
        return Math.max(leftSide, rightSide);
      }
    } else {
      // Has not been rotated
      if (target < nums[0] || target > nums[nums.length - 1]) {
        return -1;
      } else {
        return binarySearch(nums, target, 0, nums.length - 1);
      }
    }
  }

  public int binarySearch(int[] nums, int target, int left, int right) {
    if (right >= left) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        return binarySearch(nums, target, left, mid - 1);
      } else {
        return binarySearch(nums, target, mid + 1, right);
      }
    }

    return -1;
  }
}
