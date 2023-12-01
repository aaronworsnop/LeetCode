class MinStack {
  public Node top;
  public int min;

  public MinStack() {
    this.min = Integer.MAX_VALUE;
    this.top = null;
  }

  public void push(int val) {
    Node newTop = new Node(val);
    newTop.next = top;
    top = newTop;

    if (min == Integer.MAX_VALUE) {
      min = val;
    } else {
      min = Math.min(min, val);
    }
    top.min = min;

    System.out.println(top.min);
  }

  public void pop() {
    top = top.next;
    if (top == null) {
      min = Integer.MAX_VALUE;
    } else {
      min = top.min;
    }
  }

  public int top() {
    return top.val;
  }

  public int getMin() {
    return min;
  }

  private class Node {
    private int val;
    private int min;
    private Node next;

    private Node(int val) {
      this.val = val;
    }
  }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
 * obj.push(val); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
 */
