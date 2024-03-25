class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // k is the window size
    //

    // [1,-1, 3, 6, 1, 9,-1,0,-3]
    //  ^^^^^^^
    // deque: (f) 0, -3 (b)
    // out: 3, 6, 6, 9, 9

    // Edgecases
    if (nums == null || nums.length == 0) {
      return new int[] {};
    }

    int[] windowMaximums = new int[nums.length - k + 1];
    Deque<Integer> deque = new LinkedList<>();

    // Determine the maximum of the first window
    deque.offerFirst(nums[0]);
    for (int index = 1; index < k; index++) {
      if (nums[index] > deque.peekFirst()) {
        deque.clear();
        deque.offerFirst(nums[index]);
      } else {
        while (!deque.isEmpty() && deque.peekLast() < nums[index]) {
          deque.pollLast();
        }
        deque.offerLast(nums[index]);
      }
    }

    System.out.println(deque);

    windowMaximums[0] = deque.peekFirst();

    for (int window = 1; window < windowMaximums.length; window++) {
      int newNum = nums[window + k - 1];
      if (nums[window - 1] == deque.peekFirst()) {
        deque.pollFirst();
      }

      if (deque.isEmpty() || newNum > deque.peekFirst()) {
        deque.clear();
        deque.offerFirst(newNum);
      } else {
        while (!deque.isEmpty() && deque.peekLast() < newNum) {
          deque.pollLast();
        }
        deque.offerLast(newNum);
      }

      windowMaximums[window] = deque.peekFirst();
    }

    return windowMaximums;
  }
}
