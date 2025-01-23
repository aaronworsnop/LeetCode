class Solution {
  public int strStr(String haystack, String needle) {
    // We could also use base26 number maths in a similar
    // sliding window approach to improve the effeciency of this
    // algorithm, because create substrings is very inneficient.

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