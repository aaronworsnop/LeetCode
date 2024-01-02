class Solution125 {
  public boolean isPalindrome(String s) {
    int start = 0;
    int last = s.length() - 1;
    while (start <= last) {
      char left = s.charAt(start);
      char right = s.charAt(last);
      if (!Character.isLetterOrDigit(left)) {
        start++;
      } else if (!Character.isLetterOrDigit(right)) {
        last--;
      } else {
        if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
          return false;
        }
        start++;
        last--;
      }
    }
    return true;
  }
}
