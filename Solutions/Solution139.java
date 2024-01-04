class Solution139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dictionary = new HashSet<>();
    for (String word : wordDict) {
      dictionary.add(word);
    }

    return wordBreakCalculator(s, dictionary);
  }

  private boolean wordBreakCalculator(String s, Set<String> dictionary) {
    // If we the end of the word `s`, we have broken it successfully into
    // words in `dictionary`
    if (s.length() < 1) return true;

    // Find breaking words in `dictionary` to see if it leads to a
    // successful complete breaking.
    for (int end = 1; end <= s.length(); end++) {
      if (dictionary.contains(s.substring(0, end))) {
        if (wordBreakCalculator(s.substring(end, s.length()), dictionary)) {
          return true;
        }
      }
    }

    return false;
  }
}
