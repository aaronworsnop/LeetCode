/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {

    // Edgecases
    if (head == null | head.next == null) {
      return null;
    }

    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode stop = head;
    for (int nTh = n; nTh > 0; nTh--) {
      stop = stop.next;
    }

    ListNode breakPoint = dummy;
    int size = n;

    while (stop != null) {
      stop = stop.next;
      breakPoint = breakPoint.next;
      size++;
    }

    if (n == 1) {
      // Edgecase
      breakPoint.next = null;
    } else if (n == size) {
      // Edgecase
      return head.next;
    } else {
      breakPoint.next = breakPoint.next.next;
    }

    return head;
  }
}
