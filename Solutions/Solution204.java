class Solution204 {
  public int countPrimes(int n) {
    // start with two, doesn't divide and go up
    // start counting from 2, include 2 and only do odd numbers

    int primes = 0;

    if (n <= 2) {
      return primes;
    }

    boolean[] composite = new boolean[n];
    composite[0] = true;

    for (int number = 0; number < n - 1; number++) {
      if (composite[number] != true) {
        primes++;
        for (int multiple = 2; (number + 1) * multiple - 1 < n; multiple++) {
          composite[(number + 1) * multiple - 1] = true;
        }
      }
    }

    return primes;
  }
}
