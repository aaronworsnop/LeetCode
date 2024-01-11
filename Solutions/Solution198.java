class Solution198 {
  int[] markings;

  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];

    markings = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      markings[i] = -1;
    }

    return Math.max(robberyCalculator(nums, 0), robberyCalculator(nums, 1));
  }

  private int robberyCalculator(int[] nums, int house) {
    if (house >= nums.length) return 0;
    System.out.println(house);

    if (markings[house] == -1) {
      return nums[house]
          + Math.max(robberyCalculator(nums, house + 2), robberyCalculator(nums, house + 3));
    } else {
      return markings[house];
    }
  }
}
