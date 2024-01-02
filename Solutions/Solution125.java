class Solution125 {
  public boolean isPalindrome(String s) {
    // Is a string a palindrome? Given a string s

    // Removing all non-english characters and converting to lowercase
    s = s.replaceAll("[^A-Za-z0-9]", "");
    s = s.toLowerCase();

    // If the string is only one letter, it is a palindrome
    if (s.length() == 1) {
      return true;
    }

    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        System.out.println(s);
        System.out.println(s.charAt(i));
        return false;
      }
    }

    return true;
  }
}
