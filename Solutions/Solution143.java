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

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // `slow` is now the head of the second list, to be reversed
    // `head` is the head of the first list.
    ListNode finish = slow;
    slow = slow.next;
    finish.next = null;

    // Reverse the second list
    reverseLinkedList(slow);

    // Merge the two lists, alternatingly and starting with the first
    // list.
    mergeLinkedLists(head, slow);
  }

  private void reverseLinkedList(ListNode head) {
    Stack<Integer> stack = new Stack<>();

    ListNode current = head;

    while (current != null) {
      stack.push(current.val);
      current = current.next;
    }

    current = head;

    while (!stack.isEmpty()) {
      current.val = stack.pop();
      current = current.next;
    }
  }

  private void mergeLinkedLists(ListNode list1, ListNode list2) {
    while (list2 != null) {
      ListNode list1Next = list1.next;
      ListNode list2Next = list2.next;

      list1.next = list2;

      if (list1Next == null) {
        break;
      }

      list2.next = list1Next;
      list1 = list1Next;
      list2 = list2Next;
    }
  }
}
