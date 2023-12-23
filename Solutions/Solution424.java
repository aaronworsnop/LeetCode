class Solution424 {
  public int characterReplacement(String s, int k) {

    // Edgecases
    if (s.length() < 2) {
      return s.length();
    }

    Map<Character, Integer> characterCount = new HashMap<>();
    int left = 0;
    int longestRepeating = 0;

    for (int right = 0; right < s.length(); right++) {
      characterCount.put(s.charAt(right), characterCount.getOrDefault(s.charAt(right), 0) + 1);

      while (right - left + 1 - getMostPopulusCharacterCount(characterCount) > k) {
        characterCount.replace(s.charAt(left), characterCount.get(s.charAt(left)) - 1);
        left++;
      }

      longestRepeating = Math.max(longestRepeating, right - left + 1);
    }

    return longestRepeating;
  }

  /** Find the character with the highest frequency (Positive only) */
  private int getMostPopulusCharacterCount(Map<Character, Integer> characterCount) {
    int maxCount = 0;

    for (int count : characterCount.values()) {
      maxCount = Math.max(maxCount, count);
    }

    return maxCount;
  }
}
