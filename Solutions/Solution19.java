/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {}
 * ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
 * this.next = next; } }
 */
class Solution19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    // Use a stack to keep track of the listnodes from the end

    if (head == null || head.next == null) {
      return null;
    }

    int size = 0;
    ListNode current = head;
    Stack<ListNode> stack = new Stack<>();
    while (current != null) {
      stack.push(current);
      current = current.next;
      size++;
    }

    // current = null, that's helpful here

    for (int nTh = 0; nTh < n - 2; nTh++) {
      stack.pop();
    }

    ListNode cont;
    if (n == 1) {
      cont = current;
    } else {
      cont = stack.pop();
    }

    if (n == size) {
      return cont;
    }

    stack.pop();
    ListNode breakPoint = stack.pop();
    breakPoint.next = cont;
    return head;
  }
}
