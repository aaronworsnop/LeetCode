class Solution567 {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    Map<Character, Integer> freqMap = new HashMap<>();
    for (char character : s1.toCharArray()) {
      freqMap.put(character, freqMap.getOrDefault(character, 0) + 1);
    }

    int[] freqArray = new int[26];
    for (int letter = 0; letter < s1.length() - 1; letter++) {
      freqArray[s2.charAt(letter) - 'a']++;
    }

    int window = 0;

    while (window <= s2.length() - s1.length()) {
      freqArray[s2.charAt(window + s1.length() - 1) - 'a']++;
      if (freqMap.containsKey(s2.charAt(window))) {
        // Match?
        boolean match = true;
        for (char letter = 'a'; letter <= 'z'; letter++) {
          if (!freqMap.containsKey(letter)) {
            if (freqArray[letter - 'a'] == 0) {
              continue;
            } else {
              match = false;
              break;
            }
          }

          if (freqArray[letter - 'a'] != freqMap.get(letter)) {
            match = false;
            break;
          }
        }

        if (match) return true;
      }

      freqArray[s2.charAt(window) - 'a']--;
      window++;
    }

    return false;
  }
}
