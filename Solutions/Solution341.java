public class NestedIterator implements Iterator<Integer> {
  private Stack<Integer> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.stack = new Stack<>();
    dfs(nestedList);
    Collections.reverse(stack);
  }

  @Override
  public Integer next() {
    if (!stack.isEmpty()) {
      return stack.pop();
    } else {
      return null;
    }
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  private void dfs(List<NestedInteger> nestedList) {
    for (NestedInteger item : nestedList) {
      if (item.isInteger()) {
        stack.push(item.getInteger());
      } else {
        dfs(item.getList());
      }
    }
  }
}
