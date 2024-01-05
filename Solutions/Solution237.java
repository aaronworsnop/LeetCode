class Solution237 {
  public void deleteNode(ListNode node) {
    while (node.next != null) {
      node.val = node.next.val;
      if (node.next.next == null) {
        node.next = null;
        break;
      }
      node = node.next;
    }
  }
}
