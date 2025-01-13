class Solution {
  public int[] productExceptSelf(int[] nums) {

    int length = nums.length;

    // Edgecases
    if (nums == null || nums.length < 2) {
      return new int[] { 0 };
    }

    // Pass through forwards capturing 'pre-products'
    int[] answer = new int[length];
    answer[0] = 1;

    for (int index = 1; index < length; index++) {
      answer[index] = answer[index - 1] * nums[index - 1];
    }

    // Pass through backwards incorporating 'post-products'
    int postProduct = 1;
    for (int index = length - 2; index >= 0; index--) {
      postProduct *= nums[index + 1];
      answer[index] *= postProduct;
    }

    return answer;
  }
}