class Solution75 {
  public void sortColors(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  private void quickSort(int[] nums, int left, int right) {
    if (left < right) {
      int pivot = partition(nums, left, right);
      quickSort(nums, left, pivot);
      quickSort(nums, pivot + 1, right);
    }
  }

  private int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    int i = left + 1;

    for (int j = i; j <= right; j++) {
      if (nums[j] < pivot) {
        swap(nums, i, j);
        i++;
      }
    }

    swap(nums, left, i - 1);
    return i - 1;
  }

  private void swap(int[] nums, int pos1, int pos2) {
    int temp = nums[pos1];
    nums[pos1] = nums[pos2];
    nums[pos2] = temp;
  }
}
