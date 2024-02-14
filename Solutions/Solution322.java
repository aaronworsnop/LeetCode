class Solution322 {
  public int coinChange(int[] coins, int amount) {
    // Edge and known cases
    if (coins == null || coins.length == 0) {
      return -1;
    }

    if (amount == 0) {
      return 0;
    }

    if (coins.length == 1 && amount % coins[0] != 0) {
      return -1;
    }

    int[] makeups = new int[amount + 1];

    for (int i = 1; i < makeups.length; i++) {
      makeups[i] = amount;
    }

    for (int target = 1; target <= amount; target++) {
      for (int denomination = 0; denomination < coins.length; denomination++) {
        if (target - coins[denomination] >= 0) {
          makeups[target] = Math.min(makeups[target], makeups[target - coins[denomination]] + 1);
        }
      }
    }

    if (makeups[amount] == amount) {
      for (int denomination : coins) {
        if (denomination == 1) {
          return amount;
        }
      }
      return -1;
    } else {
      return makeups[amount];
    }
  }
}
