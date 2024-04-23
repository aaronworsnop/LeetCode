class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    return mergeSort(lists, 0, lists.length - 1);
  }

  private ListNode mergeSort(ListNode[] lists, int start, int end) {
    if (start >= end) {
      return lists[start];
    }

    int mid = start + (end - start) / 2;
    ListNode left = mergeSort(lists, start, mid);
    ListNode right = mergeSort(lists, mid + 1, end);
    return merge2Lists(left, right);
  }

  private ListNode merge2Lists(ListNode head1, ListNode head2) {
    ListNode dummy = new ListNode();
    ListNode current = dummy;

    while (head1 != null && head2 != null) {
      if (head1.val > head2.val) {
        current.next = head2;
        head2 = head2.next;
      } else {
        current.next = head1;
        head1 = head1.next;
      }

      current = current.next;
    }

    if (head1 == null) {
      current.next = head2;
    } else {
      current.next = head1;
    }

    return dummy.next;
  }
}
