class Solution76 {
  public String minWindow(String s, String t) {
    String min = "";
    int minLength = Integer.MAX_VALUE;
    int m = s.length();
    int n = t.length();

    // Edgecases
    if (m < n) {
      return "";
    }

    // Create a map of all the characters in `t` and their frequiencies
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char character : t.toCharArray()) {
      freqMap.put(character, freqMap.getOrDefault(character, 0) + 1);
    }

    Map<Character, Integer> substringMap = new HashMap<>();
    int left = 0;
    int right = left;
    int matches = 0;
    int requiredMatches = freqMap.size();

    while (right < s.length()) {
      char current = s.charAt(right);

      substringMap.put(current, substringMap.getOrDefault(current, 0) + 1);

      if (freqMap.containsKey(current) && freqMap.get(current) == substringMap.get(current)) {
        matches++;
      }

      while (left <= right && matches == requiredMatches) {
        char toRemove = s.charAt(left);

        if (right - left + 1 < minLength) {
          minLength = right - left + 1;
          min = s.substring(left, right + 1);
        }

        substringMap.put(toRemove, substringMap.get(toRemove) - 1);

        if (freqMap.containsKey(toRemove) && substringMap.get(toRemove) < freqMap.get(toRemove)) {
          matches--;
        }

        left++;
      }

      right++;
    }

    return min;
  }
}
