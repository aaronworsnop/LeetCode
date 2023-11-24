import java.util.*;

class Solution350 {
  public int[] intersect(int[] nums1, int[] nums2) {
    // Find all matching values and return them;

    List<Integer> listNums1 = new ArrayList<>();
    List<Integer> listNums2 = new ArrayList<>();
    List<Integer> returnList = new ArrayList<>();

    for (int i = 0; i < nums1.length; i++) {
      listNums1.add(nums1[i]);
    }

    for (int i = 0; i < nums2.length; i++) {
      listNums2.add(nums2[i]);
    }

    for (int i = 0; i < listNums1.size(); i++) {
      if (listNums2.indexOf(listNums1.get(i)) != -1) {
        returnList.add(listNums1.get(i));
        listNums2.remove(listNums2.indexOf(listNums1.get(i)));
        listNums1.remove(i);
        i = i - 1;
      }
    }

    int[] toReturn = new int[returnList.size()];

    for (int i = 0; i < returnList.size(); i++) {
      toReturn[i] = returnList.get(i);
    }

    return toReturn;
  }
}
