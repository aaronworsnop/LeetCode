class Solution134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int[] netGas = new int[gas.length];
    int total = 0;

    for (int station = 0; station < gas.length; station++) {
      netGas[station] = gas[station] - cost[station];
      total += netGas[station];
    }

    if (total < 0) {
      return -1;
    }

    total = 0;
    int positiveFor = 0;
    int station = 0;
    while (positiveFor < gas.length) {
      total += netGas[station];
      if (total < 0) {
        total = 0;
        positiveFor = 0;
      } else {
        positiveFor++;
      }

      station++;
      station %= gas.length;
    }

    return station;
  }
}
