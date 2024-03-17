class Solution {
  public int calculate(String s) {
    // calculate(String s)
    // + - / *

    // BEDMAS -> DM, AS

    // String manipulation
    // "3+2*4" (= 11)
    // "11"

    // "3+10/5-1" (= 4)
    //          ^
    // d: 3, 2, 1
    // o: +, -
    // rememberOperation:
    // rememberDigit: 5

    // Edgecase
    if (s == null || s.length() == 0) {
      return 0;
    }

    Stack<Integer> digits = new Stack<>();
    Stack<Character> operations = new Stack<>();
    StringBuilder digitBuilder = new StringBuilder();

    // Add operations to a stack of orders to be executed, executing high priority
    // operations immediately
    int index = 0;
    while (index < s.length() || !operations.isEmpty()) {
      if (index >= s.length()) {
        // Evaluate the rest of operations
        int secondOperand = digits.pop();
        int firstOperand = digits.pop();
        char operation = operations.pop();

        int evaluation = executeOperation(operation, firstOperand, secondOperand);
        digits.push(evaluation);

        index++;
        continue;
      }

      // Continue to add operations to stack
      char character = s.charAt(index);
      if (isSpace(character)) {
        index++;
        continue;
      }

      // Add either an operation or a digit to their corresponding stack
      if (isOperation(character)) {
        // Operation
        operations.push(character);
      } else {
        // Digit
        digitBuilder.append(character);

        while (index < s.length() - 1
            && !isOperation(s.charAt(index + 1))
            && !isSpace(s.charAt(index + 1))) {
          // Parse the entire number
          character = s.charAt(index + 1);
          digitBuilder.append(character);
          index++;
        }

        int digit = Integer.valueOf(digitBuilder.toString());

        if (!operations.isEmpty() && operations.peek() == '-') {
          operations.pop();
          operations.push('+');
          digit = -digit;
        }

        digits.push(digit);
        digitBuilder.setLength(0);

        if (!operations.isEmpty() && (operations.peek() == '*' || operations.peek() == '/')) {
          // Our previous operation is high priority, execute it
          int secondOperand = digits.pop();
          int firstOperand = digits.pop();
          char operation = operations.pop();

          int evaluation = executeOperation(operation, firstOperand, secondOperand);
          digits.push(evaluation);
        }
      }

      index++;
    }

    return digits.pop();
  }

  private boolean isSpace(char character) {
    return character == ' ';
  }

  private boolean isOperation(char character) {
    if (character == '+' || character == '-' || character == '*' || character == '/') {
      return true;
    }

    return false;
  }

  private int executeOperation(char operation, int firstOperand, int secondOperand) {
    if (operation == '+') {
      // Addition
      return firstOperand + secondOperand;
    } else if (operation == '-') {
      // Subtraction
      return firstOperand - secondOperand;
    } else if (operation == '*') {
      // Multiplication
      return firstOperand * secondOperand;
    } else {
      // Division
      return firstOperand / secondOperand;
    }
  }
}
