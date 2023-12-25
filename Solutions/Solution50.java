class Solution50 {
  public double myPow(double x, int n) {
    double result = myPowCalculatorRecursive(x, Math.abs(n));
    return (n > 0) ? result : 1 / result;
  }

  private double myPowCalculatorRecursive(double x, int n) {
    // 2^10 = 2^5 * 2^5
    // 2^5 = 2 * 2^2 * 2^2
    // 2^2 = 2 * 2

    if (x == 0) return 0;
    else if (n == 1) return x;
    else if (n == 0) return 1;

    double result = myPowCalculatorRecursive(x, n / 2);
    result = result * result;
    if (n % 2 != 0) result = result * x;
    return result;
  }
}
