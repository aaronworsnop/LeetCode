class Solution179 {
  public String largestNumber(int[] nums) {
    // Edgecase
    if (nums.length == 0) {
      return "";
    } else if (nums.length == 1) {
      return String.valueOf(nums[0]);
    }

    // Sort the array by largest first elements (if equal, then least digits).
    sort(nums, 0, nums.length - 1);

    // Print the array number by number to get the largest number.
    StringBuilder builder = new StringBuilder();
    for (int num = 0; num < nums.length; num++) {
      builder.append(String.valueOf(nums[num]));
    }

    String result = builder.toString();

    // Remove leading zeros
    int index = 0;
    while (index < result.length() - 1 && result.charAt(index) == '0') {
      index++;
    }
    return result.substring(index, result.length());
  }

  private void sort(int[] nums, int left, int right) {
    if (left >= right) return;

    int mid = left + (right - left) / 2;
    sort(nums, left, mid);
    sort(nums, mid + 1, right);
    merge(nums, left, mid, right);
  }

  private void merge(int[] nums, int left, int mid, int right) {
    int[] workingNums = new int[right - left + 1];
    int leftPoint = left;
    int rightPoint = mid + 1;

    for (int num = 0; num < workingNums.length; num++) {
      if (leftPoint > mid) {
        workingNums[num] = nums[rightPoint++];
      } else if (rightPoint > right) {
        workingNums[num] = nums[leftPoint++];
      } else {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(nums[leftPoint]));
        builder.append(String.valueOf(nums[rightPoint]));
        String leftFirst = builder.toString();

        builder.setLength(0);
        builder.append(String.valueOf(nums[rightPoint]));
        builder.append(String.valueOf(nums[leftPoint]));
        String rightFirst = builder.toString();

        if (leftFirst.compareTo(rightFirst) > 0) {
          workingNums[num] = nums[leftPoint++];
        } else {
          workingNums[num] = nums[rightPoint++];
        }
      }
    }

    // Copy working to real array
    for (int num = 0; num < workingNums.length; num++) {
      nums[num + left] = workingNums[num];
    }
  }
}
