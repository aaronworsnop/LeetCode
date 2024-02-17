class Solution {
  public ListNode oddEvenList(ListNode head) {
    // Edge and known cases
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }

    ListNode odd = head;
    ListNode even = head.next;
    ListNode dummy = even;

    while (even != null) {
      if (even.next != null) {
        odd.next = even.next;
      } else {
        odd.next = null;
      }

      if (even.next != null && even.next.next != null) {
        even.next = even.next.next;
      } else {
        even.next = null;
      }

      if (odd.next != null) {
        odd = odd.next;
      }
      even = even.next;
    }

    odd.next = dummy;

    return head;
  }
}
