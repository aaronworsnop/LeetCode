class Solution567 {
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;
    // All we need is to find a mix-and-mash of the letters
    // in our s1 by counting.

    // We can use a hashmap and run through it to store what we have
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char character : s1.toCharArray()) {
      freqMap.put(character, freqMap.getOrDefault(character, 0) + 1);
    }

    System.out.println(freqMap);

    int left = 0;
    int window = left;

    while (left <= s2.length() - s1.length()) {
      if (freqMap.containsKey(s2.charAt(left))) {
        Map<Character, Integer> freqMapCopy = new HashMap<>(freqMap);
        window = left;

        while (!freqMapCopy.isEmpty()) {
          if (freqMapCopy.containsKey(s2.charAt(window))) {
            freqMapCopy.put(s2.charAt(window), freqMapCopy.get(s2.charAt(window)) - 1);
            if (freqMapCopy.get(s2.charAt(window)) == 0) freqMapCopy.remove(s2.charAt(window));
          } else {
            break;
          }

          if (freqMapCopy.isEmpty()) return true;
          window++;
        }
      }

      left++;
    }

    return false;
  }
}
