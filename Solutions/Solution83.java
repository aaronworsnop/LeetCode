class Solution83 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;

    while (current != null) {
      int dupVal = current.val;
      ListNode dupEnd = current.next;
      while (dupEnd != null && dupEnd.val == dupVal) {
        dupEnd = dupEnd.next;
      }
      current.next = dupEnd;
      current = current.next;
    }

    return head;
  }
}
