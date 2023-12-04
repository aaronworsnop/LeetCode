import java.util.Stack;

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    // Edgecases
    if (temperatures.length == 1) {
      return new int[] {0};
    }

    // Key is index, value is temperature
    Stack<Integer> workingStack = new Stack<>();
    int[] untilWarmer = new int[temperatures.length];

    for (int day = 0; day < temperatures.length; day++) {
      int temperature = temperatures[day];
      while (!workingStack.isEmpty() && temperature > temperatures[workingStack.peek()]) {
        untilWarmer[workingStack.peek()] = day - workingStack.pop();
      }
      workingStack.push(day);
    }

    return untilWarmer;
  }
}
