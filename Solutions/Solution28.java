public class Solution28 {
  public int strStr(String haystack, String needle) {
    // We can use a window solution for this
    if (haystack.length() == 0) {
      return -1;
    } else if (!haystack.contains(needle)) {
      return -1;
    }
    return haystack.indexOf(needle);
  }
}
