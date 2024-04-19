class Solution {
  public String gcdOfStrings(String str1, String str2) {
    // If there is a common divisor, `str1 + str2 === str2 + str1`

    // AB + ABAB = ABABAB
    // ABAB + AB = ABABAB

    // ABA + AB = ABAAB
    // AB + ABA = ABABA

    // Find the GREATEST common divisor

    // ABAB ABABAB

    // 6 % 4 = 2
    // 4 % 2 = 0

    // 4 % 6 = 4
    // 6 % 4 = 2
    // 4 % 2 = 0

    // Edge and known cases
    if (str1.length() == 0 || str2.length() == 0) {
      return "";
    }

    // Determine if there is a common divisor
    if (!(str1 + str2).equals(str2 + str1)) {
      return "";
    }

    int blockSize = gcd(str1.length(), str2.length());
    return str1.substring(0, blockSize);
  }

  private int gcd(int length1, int length2) {
    if (length2 == 0) {
      return length1;
    } else {
      return gcd(length2, length1 % length2);
    }
  }
}
