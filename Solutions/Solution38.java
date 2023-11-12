public class Solution38 {
  public String countAndSay(int n) {
    // Base case
    if (n == 1) {
      return "1";
    }

    String sayDigit = countAndSay(n - 1);
    StringBuilder builder = new StringBuilder();

    // Pointers
    int start = 0;
    int end = 0;

    while (end < sayDigit.length() && start < sayDigit.length()) {
      char currentDigit = sayDigit.charAt(start);
      try {
        while (sayDigit.charAt(end) == currentDigit) {
          end++;
        }
      } catch (Exception e) {

      }

      builder.append(String.valueOf(end - start));
      builder.append(currentDigit);

      start = end;
    }

    return builder.toString();
  }
}
