class Solution {
  public int strStr(String haystack, String needle) {
    // Edgecases
    if (needle.length() > haystack.length()) {
      return -1;
    }

    int start = 0;
    int end = needle.length();

    while (end <= haystack.length()) {
      String current = haystack.substring(start, end);

      if (current.equals(needle)) {
        return start;
      }

      start++;
      end++;
    }

    return -1;
  }
}