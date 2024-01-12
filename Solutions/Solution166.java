class Solution166 {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) return "0";

    StringBuilder builder = new StringBuilder();
    if (numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) {
      builder.append("-");
    }

    long dividend = Math.abs((long) numerator);
    long divisor = Math.abs((long) denominator);
    long remainder = dividend % divisor;

    builder.append(dividend / divisor);

    if (remainder == 0) return builder.toString();

    builder.append(".");

    Map<Long, Integer> digitMap = new HashMap<>();

    while (remainder > 0) {
      if (digitMap.containsKey(remainder)) {
        builder.insert(digitMap.get(remainder), "(");
        builder.append(")");
        break;
      }

      digitMap.put(remainder, builder.length());
      remainder *= 10;
      builder.append(remainder / divisor);

      remainder %= divisor;
    }

    return builder.toString();
  }
}
