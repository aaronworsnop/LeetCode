class Solution704 {
  public int search(int[] nums, int target) {
    return binarySearch(0, nums.length - 1, nums, target);
  }

  private int binarySearch(int left, int right, int[] nums, int target) {
    if (left > right) return -1;

    int mid = left + (right - left) / 2;

    if (nums[mid] == target) return mid;
    else if (nums[mid] > target) return binarySearch(left, mid - 1, nums, target);
    else return binarySearch(mid + 1, right, nums, target);
  }
}
