class Solution287 {
  public int findDuplicate(int[] nums) {
    // We can act as if the number at a specific index points to
    // an index. This way we construct a graph and can use an algorithm
    // that detects cycles.

    // We can have two pointers move at different speeds, and if they
    // ever become the same number, there must be a cycle.

    // Edgecases
    if (nums.length < 3) {
      return nums[0];
    }

    int slow = 0;
    int fast = 0;

    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) break;
    }

    fast = 0;

    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }
}
