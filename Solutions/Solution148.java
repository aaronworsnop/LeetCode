/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution148 {
  public ListNode sortList(ListNode head) {
    // 1, 2, 3 _ 4, 5 _
    // 1, 2 _ 3, 4 _
    //
    // In odd case, left will be larger
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode firstEnd = slow;
    slow = slow.next;
    firstEnd.next = null;

    ListNode first = sortList(head);
    ListNode second = sortList(slow);
    return merge(first, second);
  }

  private ListNode merge(ListNode first, ListNode second) {
    ListNode head = new ListNode();
    ListNode current = head;

    while (first != null && second != null) {
      if (first.val < second.val) {
        current.next = first;
        first = first.next;
      } else {
        current.next = second;
        second = second.next;
      }
      current = current.next;
    }

    if (first != null) current.next = first;
    else if (second != null) current.next = second;

    return head.next;
  }
}
