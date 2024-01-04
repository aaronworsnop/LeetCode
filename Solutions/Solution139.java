class Solution139 {
  Set<String> dictionary;

  /** 0: untouched 1: true -1: false */
  int[] breakable;

  public boolean wordBreak(String s, List<String> wordDict) {
    this.breakable = new int[s.length()];

    // Initialise a set with all words in `wordDict`
    this.dictionary = new HashSet<>();
    for (String word : wordDict) {
      dictionary.add(word);
    }

    return wordBreakCalculator(s, 0);
  }

  private boolean wordBreakCalculator(String s, int start) {
    // If we reach the end of the word `s`, we have broken it successfully into
    // words in `dictionary`
    if (start == s.length()) {
      return true;
    }

    // We already know the breakability of our word `s` from `start`
    if (breakable[start] != 0) {
      return breakable[start] == 1;
    }

    // Find breaking words in `dictionary` to see if it leads to a
    // successful complete breaking.
    for (int end = start + 1; end <= s.length(); end++) {
      if (dictionary.contains(s.substring(start, end)) && wordBreakCalculator(s, end)) {
        // Mark as breakable
        breakable[start] = 1;
        return true;
      }
    }

    // Make as not breakable
    breakable[start] = -1;
    return false;
  }
}
