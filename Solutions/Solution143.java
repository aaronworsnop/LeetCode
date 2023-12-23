/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution143 {
  public void reorderList(ListNode head) {

    if (head == null || head.next == null) {
      return;
    }

    int size = 0;
    Stack<Integer> oddStack = new Stack<>();

    ListNode current = head;
    ListNode oldHead = new ListNode();
    ListNode oldCurrent = oldHead;

    while (current != null) {
      oddStack.push(current.val);
      oldCurrent.val = current.val;

      size++;
      current = current.next;

      if (current != null) {
        oldCurrent.next = new ListNode();
        oldCurrent = oldCurrent.next;
      }
    }

    oldCurrent = oldHead;
    current = head;

    for (int i = 0; i < size; i++) {
      if (i % 2 == 0) {
        current.val = oldCurrent.val;
        current = current.next;
        oldCurrent = oldCurrent.next;
      } else {
        current.val = oddStack.pop();
        current = current.next;
      }
    }
  }
}
