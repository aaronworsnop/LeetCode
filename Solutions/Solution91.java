class Solution91 {
  public int[] cache;

  public int numDecodings(String s) {
    // Initialise the cache
    cache = new int[s.length() + 1];
    for (int i = 0; i < cache.length; i++) {
      cache[i] = -1;
    }

    return numDecodingsCalculator(s, 0);
  }

  public int numDecodingsCalculator(String s, int character) {
    if (character > s.length() - 1) return 1;

    if (cache[character] != -1) return cache[character];

    if (s.charAt(character) == '0') {
      // No single or double combination
      cache[character] = 0;
      return 0;
    } else if (character < s.length() - 1
        && (s.charAt(character) == '1'
            || s.charAt(character) == '2' && s.charAt(character + 1) < '7')) {
      // A single and double combination
      cache[character] =
          numDecodingsCalculator(s, character + 1) + numDecodingsCalculator(s, character + 2);
      return cache[character];
    } else {
      // A single combination
      if (cache[character] != -1) return cache[character];
      else {
        cache[character] = numDecodingsCalculator(s, character + 1);
        return cache[character];
      }
    }
  }
}
