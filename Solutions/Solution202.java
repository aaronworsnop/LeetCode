class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = sumSquaredDigits(n);
        }

        return true;
    }

    private int sumSquaredDigits(int n) {
        int sum = 0;

        do {
            sum += (int) Math.pow((n % 10), 2);
            n /= 10;
        } while (n > 0);

        return sum;
    }
}