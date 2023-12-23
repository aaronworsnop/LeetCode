class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    int longestSubstring = 0;

    int left = 0;
    int right = 0;

    Set<Character> seen = new HashSet<>();

    while (right < s.length()) {
      if (!seen.contains(s.charAt(right))) {
        seen.add(s.charAt(right));
        right++;
        longestSubstring = Math.max(longestSubstring, right - left);
      } else {
        seen.remove(s.charAt(left));
        left++;
      }
    }
    return longestSubstring;
  }
}
