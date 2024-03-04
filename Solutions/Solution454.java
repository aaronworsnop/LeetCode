class Solution454 {
  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

    if (nums1 == null || nums1.length == 0) {
      return 0;
    }

    int n = nums1.length;
    Map<Integer, Integer> map = new HashMap<>();

    for (int k = 0; k < n; k++) {
      for (int l = 0; l < n; l++) {
        map.put(nums3[k] + nums4[l], map.getOrDefault(nums3[k] + nums4[l], 0) + 1);
      }
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        count += map.getOrDefault(-(nums1[i] + nums2[j]), 0);
      }
    }

    return count;
  }
}
