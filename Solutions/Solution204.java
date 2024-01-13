class Solution204 {
  public int countPrimes(int n) {
    // start with two, doesn't divide and go up
    // start counting from 2, include 2 and only do odd numbers

    if (n <= 2) {
      return 0;
    }

    int primes = 1;

    boolean[] composite = new boolean[n + 1];
    composite[2] = true;

    for (int number = 3; number < n; number += 2) {
      if (composite[number] != true) {
        primes++;
        for (int multiple = 2; number * multiple < n; multiple++) {
          composite[number * multiple] = true;
        }
      }
    }

    return primes;
  }
}
