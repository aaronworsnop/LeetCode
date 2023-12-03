import java.util.Stack;

class Solution150 {
  public int evalRPN(String[] tokens) {
    if (tokens.length < 3) {
      return Integer.valueOf(tokens[0]);
    }

    Stack<Integer> stack = new Stack<>();

    stack.push(Integer.valueOf(tokens[0]));
    stack.push(Integer.valueOf(tokens[1]));

    for (int currentTokenIndex = 2; currentTokenIndex < tokens.length; currentTokenIndex++) {
      String token = tokens[currentTokenIndex];

      if (token.equals("+")) {
        int secondNumber = stack.pop();
        int firstNumber = stack.pop();
        stack.push(firstNumber + secondNumber);
      } else if (token.equals("-")) {
        int secondNumber = stack.pop();
        int firstNumber = stack.pop();
        stack.push(firstNumber - secondNumber);
      } else if (token.equals("*")) {
        int secondNumber = stack.pop();
        int firstNumber = stack.pop();
        stack.push(firstNumber * secondNumber);
      } else if (token.equals("/")) {
        int secondNumber = stack.pop();
        int firstNumber = stack.pop();
        stack.push(firstNumber / secondNumber);
      } else {
        stack.push(Integer.valueOf(token));
      }
    }

    return stack.pop();
  }
}
