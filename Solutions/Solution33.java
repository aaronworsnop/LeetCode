class Solution33 {
  public int search(int[] nums, int target) {
    // Find the pivot point / rotate point / where the array starts

    int start = 0;
    int least = nums[0];

    int findingLeft = 0;
    int findingRight = nums.length - 1;
    int findingMid = 0;

    while (findingLeft <= findingRight) {
      if (nums[findingLeft] < nums[findingRight]) {
        if (nums[findingLeft] < least) {
          least = nums[findingLeft];
          start = findingLeft;
        }
        break;
      }

      findingMid = findingLeft + (findingRight - findingLeft) / 2;
      if (nums[findingMid] < least) {
        least = nums[findingMid];
        start = findingMid;
      }

      if (nums[findingMid] >= nums[findingLeft]) {
        findingLeft = findingMid + 1;
      } else {
        findingRight = findingMid - 1;
      }
    }

    int left = 0;
    int right = nums.length - 1;

    if (start == left) {

    } else if (target > nums[right]) {
      right = start - 1;
    } else {
      left = start;
    }

    while (left <= right) {
      int mid = left + (right - left) / 2;
      System.out.println("Left: " + left + " | Mid: " + mid + " | Right: " + right);

      if (nums[mid] == target) return mid;
      else if (nums[mid] > target) right = mid - 1;
      else left = mid + 1;
    }

    return -1;
  }
}
