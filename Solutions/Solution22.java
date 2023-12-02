import java.util.ArrayList;
import java.util.List;

class Solution22 {
  public List<String> generateParenthesis(int n) {
    List<String> parentheses = new ArrayList();

    backtrack(parentheses, "", 0, 0, n);

    return parentheses;
  }

  public void backtrack(List<String> parentheses, String current, int open, int close, int max) {
    if (current.length() == max * 2) {
      parentheses.add(current);
      return;
    }

    if (open < max) backtrack(parentheses, current + "(", open + 1, close, max);
    if (close < open) backtrack(parentheses, current + ")", open, close + 1, max);
  }
}
