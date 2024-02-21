public class NestedIterator implements Iterator<Integer> {
  private List<Integer> temp;
  private int index;

  public NestedIterator(List<NestedInteger> nestedList) {
    this.temp = new ArrayList<>();
    index = 0;
    dfs(nestedList);
  }

  @Override
  public Integer next() {
    return temp.get(index++);
  }

  @Override
  public boolean hasNext() {
    return index < temp.size();
  }

  private void dfs(List<NestedInteger> nestedList) {
    for (NestedInteger item : nestedList) {
      if (item.isInteger()) {
        temp.add(item.getInteger());
      } else {
        dfs(item.getList());
      }
    }
  }
}
