class Solution238 {
  public int[] productExceptSelf(int[] nums) {
    // nums: [1, 2, 3, 4]
    // answer: [24, 12, 8, 6]

    // Edgecase
    if (nums.length == 0) {
      return new int[0];
    } else if (nums.length == 1) {
      // nums: [3]
      // answer: [0]
      return new int[] {0};
    }

    int forwardsMultiplier = 1;
    int[] forwardsProducts = new int[nums.length];
    forwardsProducts[0] = 1;

    int reverseMultiplier = 1;
    int[] reverseProducts = new int[nums.length];
    reverseProducts[nums.length - 1] = 1;

    for (int i = 1; i < nums.length; i++) {
      forwardsProducts[i] = nums[i - 1] * forwardsMultiplier;
      forwardsMultiplier = forwardsProducts[i];

      reverseProducts[nums.length - i - 1] = nums[nums.length - i] * reverseMultiplier;
      reverseMultiplier = reverseProducts[nums.length - i - 1];
    }

    int[] answer = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      answer[i] = forwardsProducts[i] * reverseProducts[i];
    }

    return answer;
  }
}
