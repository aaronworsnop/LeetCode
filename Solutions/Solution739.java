import java.util.Stack;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    // Edgecases
    if (temperatures.length == 1) {
      return new int[] {0};
    }

    // Key is index, value is temperature
    Stack<Pair<Integer, Integer>> workingStack = new Stack<>();
    int[] untilWarmer = new int[temperatures.length];

    for (int day = 0; day < temperatures.length; day++) {
      Pair<Integer, Integer> temperature = new Pair<>(day, temperatures[day]);
      while (!workingStack.isEmpty() && temperature.getValue() > workingStack.peek().getValue()) {
        untilWarmer[workingStack.peek().getKey()] =
            temperature.getKey() - workingStack.pop().getKey();
      }
      workingStack.push(temperature);
    }

    return untilWarmer;
  }
}
