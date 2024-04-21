class Solution23 {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    ListNode dummy = new ListNode();
    ListNode current = dummy;

    while (true) {
      int lowestVal = Integer.MAX_VALUE;
      int lowestIndex = 0;
      ListNode lowestNode = null;

      for (int listIndex = 0; listIndex < lists.length; listIndex++) {
        ListNode list = lists[listIndex];

        if (list != null) {
          if (list.val < lowestVal) {
            lowestVal = list.val;
            lowestNode = list;
            lowestIndex = listIndex;
          }
        }
      }

      if (lowestNode == null) {
        break;
      }

      lists[lowestIndex] = lowestNode.next;
      lowestNode.next = null;
      current.next = lowestNode;
      current = current.next;
    }

    return dummy.next;
  }
}
