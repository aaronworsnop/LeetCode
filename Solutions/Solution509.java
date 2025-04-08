class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fibCalc = new int[n + 1];
        fibCalc[0] = 0;
        fibCalc[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibCalc[i] = fibCalc[i - 2] + fibCalc[i - 1];
        }

        return fibCalc[n];
    }
}