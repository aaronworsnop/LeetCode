/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution206 {
  public ListNode reverseList(ListNode head) {
    // Edgecases
    if (head == null) {
      return null;
    } else if (head.next == null) {
      return head;
    }

    Stack<Integer> stack = new Stack<>();
    ListNode current = head;

    while (current != null) {
      stack.push(current.val);
      current = current.next;
    }

    System.out.println(stack);

    ListNode newHead = new ListNode();
    current = newHead;

    while (!stack.isEmpty()) {
      current.val = stack.pop();
      if (!stack.isEmpty()) {
        current.next = new ListNode();
        current = current.next;
      }
    }

    return newHead;
  }
}
