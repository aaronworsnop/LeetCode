class Solution739 {
  public int[] dailyTemperatures(int[] temperatures) {
    // Edgecases
    if (temperatures.length == 1) {
      return new int[] {0};
    }

    int[] toReturn = new int[temperatures.length];

    for (int i = 0; i < temperatures.length; i++) {
      int j = 0;
      while (j < temperatures.length - i && temperatures[i + j] <= temperatures[i]) {
        j++;
      }

      if (j + i == temperatures.length) {
        toReturn[i] = 0;
      } else {
        toReturn[i] = j;
      }
    }

    return toReturn;
  }
}
