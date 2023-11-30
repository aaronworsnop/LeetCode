class Solution20 {
  public boolean isValid(String s) {

    // Edgecases
    if (s == null || s.length() < 2) {
      return false;
    }

    // Initialise working stack
    Stack<Character> workingStack = new Stack<>();

    // Iterate through s
    for (char currentCharacter : s.toCharArray()) {
      if (currentCharacter == '}') {
        // Curly bracket
        if (workingStack.isEmpty() || workingStack.pop() != '{') {
          return false;
        }
      } else if (currentCharacter == ')') {
        // Bracket
        if (workingStack.isEmpty() || workingStack.pop() != '(') {
          return false;
        }
      } else if (currentCharacter == ']') {
        // Square bracket
        if (workingStack.isEmpty() || workingStack.pop() != '[') {
          return false;
        }
      } else {
        workingStack.add(currentCharacter);
      }
    }

    if (workingStack.isEmpty()) {
      return true;
    }

    return false;
  }
}
