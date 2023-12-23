/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
import java.util.LinkedList;

class Solution21 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    LinkedList<Integer> list = new LinkedList<Integer>();

    ListNode temp = new ListNode(0);
    ListNode current = temp;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }

      current = current.next;
    }

    // Edge cases
    if (list1 != null) {
      current.next = list1;
      list1 = list1.next;
    }

    if (list2 != null) {
      current.next = list2;
      list2 = list2.next;
    }

    return temp.next;
  }
}
