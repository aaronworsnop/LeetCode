class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> subPalindromes = new ArrayList<>();
    findPalindromes(subPalindromes, new ArrayList<>(), s, 0);
    return subPalindromes;
  }

  private void findPalindromes(
      List<List<String>> subPalindromes, List<String> currentPalindromes, String s, int start) {
    if (start >= s.length()) {
      subPalindromes.add(new ArrayList<>(currentPalindromes));
      return;
    }

    for (int end = start; end < s.length(); end++) {
      if (checkPalindrome(s, start, end)) {
        currentPalindromes.add(s.substring(start, end + 1));
        findPalindromes(subPalindromes, currentPalindromes, s, end + 1);
        currentPalindromes.remove(currentPalindromes.size() - 1);
      }
    }
  }

  private boolean checkPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start++) != s.charAt(end--)) return false;
    }

    return true;
  }
}
