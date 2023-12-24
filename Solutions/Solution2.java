import java.util.*;

class Solution2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;

    ListNode toReturn = new ListNode();
    ListNode current = new ListNode();
    current = toReturn;

    while (l1 != null || l2 != null) {
      if (l1 == null) {
        if (l2.val + carry > 9) {
          ListNode next = new ListNode();
          next.val = (l2.val + carry) % 10;
          current.next = next;
          current = next;
          carry = 1;
          l2 = l2.next;
        } else {
          ListNode next = new ListNode();
          next.val = l2.val + carry;
          current.next = next;
          current = next;
          carry = 0;
          l2 = l2.next;
        }
      } else if (l2 == null) {
        if (l1.val + carry > 9) {
          ListNode next = new ListNode();
          next.val = (l1.val + carry) % 10;
          current.next = next;
          current = next;
          carry = 1;
          l1 = l1.next;
        } else {
          ListNode next = new ListNode();
          next.val = l1.val + carry;
          current.next = next;
          current = next;
          carry = 0;
          l1 = l1.next;
        }
      } else {
        if (l1.val + l2.val + carry > 9) {
          ListNode next = new ListNode();
          next.val = (l1.val + l2.val + carry) % 10;
          current.next = next;
          current = next;
          carry = 1;
          l1 = l1.next;
          l2 = l2.next;
        } else {
          ListNode next = new ListNode();
          next.val = l1.val + l2.val + carry;
          current.next = next;
          current = next;
          carry = 0;
          l2 = l2.next;
          l1 = l1.next;
        }
      }
    }

    if (carry == 1) {
      ListNode next = new ListNode();
      next.val = 1;
      current.next = next;
    }
    return toReturn.next;
  }
}
