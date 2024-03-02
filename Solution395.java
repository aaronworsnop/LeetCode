class Solution395 {
  public int longestSubstring(String s, int k) {
    // Create a map of each character and how many times they have appeared
    // Populate at each index how many characters have a frequency greater than k, similtaneously
    // Count the longest continous stream with greater than k

    if (s == null || s.length() == 0 || s.length() < k) {
      return 0;
    } else if (k <= 1) {
      return s.length();
    }

    int[] frequency = new int[26];
    for (int index = 0; index < s.length(); index++) {
      frequency[s.charAt(index) - 'a']++;
    }

    int mid = 0;
    while (mid < s.length() && frequency[s.charAt(mid) - 'a'] >= k) {
      mid++;
    }

    if (mid >= s.length()) {
      return mid;
    }

    int longestOfLeft = longestSubstring(s.substring(0, mid), k);
    while (mid < s.length() && frequency[s.charAt(mid) - 'a'] < k) {
      mid++;
    }
    int longestOfRight = longestSubstring(s.substring(mid, s.length()), k);
    return Math.max(longestOfLeft, longestOfRight);

    // aaabb
    // ^   ^
  }
}
