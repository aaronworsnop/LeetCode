class Solution771 {
  public int numJewelsInStones(String jewels, String stones) {
    // Edgecase
    if (jewels.length() == 0 || stones.length() == 0) {
      return 0;
    }

    // Populate a set of all jewels
    Set<Character> jewelTypes = new HashSet<>();
    for (int index = 0; index < jewels.length(); index++) {
      jewelTypes.add(jewels.charAt(index));
    }

    // Count how many jewels we have
    int count = 0;
    for (int index = 0; index < stones.length(); index++) {
      if (jewelTypes.contains(stones.charAt(index))) {
        count++;
      }
    }

    return count;
  }
}
