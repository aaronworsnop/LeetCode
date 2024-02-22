class Solution {
  public List<Integer> diffWaysToCompute(String expression) {
    Map<String, List<Integer>> memo = new HashMap<>();
    return getDiffWays(0, expression.length() - 1, memo, expression);
  }

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*');
  }

  private List<Integer> getDiffWays(
      int i, int j, Map<String, List<Integer>> memo, String expression) {
    String key = i + "-" + j;
    if (memo.containsKey(key)) {
      return memo.get(key);
    }

    int length = j - i + 1;

    // If the length of our substring is 1 or 2, we have a number
    if (length < 3) {
      List<Integer> result = new ArrayList<>();
      result.add(Integer.parseInt(expression.substring(i, i + length)));
      memo.put(key, result);
      return result;
    }

    // If it's not a number, we want to evaluate every operator within
    // our substring
    List<Integer> result = new ArrayList<>();

    for (int index = i; index <= j; index++) {
      if (isOperator(expression.charAt(index))) {
        // The current character is an operation
        char operation = expression.charAt(index);

        List<Integer> left = getDiffWays(i, index - 1, memo, expression);
        List<Integer> right = getDiffWays(index + 1, j, memo, expression);

        for (int l : left) {
          for (int r : right) {
            if (operation == '+') {
              result.add(l + r);
            } else if (operation == '-') {
              result.add(l - r);
            } else if (operation == '*') {
              result.add(l * r);
            }
          }
        }
      }
    }

    memo.put(key, result);
    return result;
  }
}
