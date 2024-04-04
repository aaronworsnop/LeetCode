/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1, 2, 3, 4, 5 | reverse(current, k) | k: 2
        // (reset head)
        // 2, 1, 3, 4, 5 | traverse k nodes
        //       ^ 
        // 2, 1, 4, 3, 5 | reverse(current, k)
        // 2, 1, 3, 4, 5 | traverse k nodes
        //             ^ | 

        // reverse()
        // stack: (b) 1, 2, 3, 4 (t)
        // if we don't have k nodes, return the head without change

        // Helper function that reverses a linkedlist (k size), returns its head

        // Testcases
        // 1, 2, 3, 4, 5 | k: 3
        // 1, 2, 3, 4 | k: 2
        // 1 | k: 0
        // {NULL} | k: 7
        // 1, 2 | k: 2
        // 1, 2 | k: 3

        // Edgecase and known cases
        if (head == null || head.next == null || k < 2) {
            // No change to original list
            return head;
        }

        // We don't need to check if `k` is longer than the list

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Capture the final head node after reversals
        ListNode newHead = head;
        for (int count = 1; count < k; count++) {
            newHead = newHead.next;
        }
        head = newHead;

        //     _ 
        //  2, 1, 3, 4, 5 | k: 2
        //  ^
        // head: ^ | dummy: & | current: _

        // Reverse each `k`-sized window in the list
        while (current != null) {
            ListNode nextWindow = reverseNodes(current.next, k);

            current.next = nextWindow;
            for (int count = 0; count < k; count++) {
                if (current != null) {
                    current = current.next;
                }
            }
        }

        return head;
    }

    public ListNode reverseNodes(ListNode head, int windowLength) {
        // Edgecases
        if (head == null || head.next == null || windowLength < 2) {
            return head;
        }

        Stack<ListNode> reverseStack = new Stack<>();

        // reverseNodes(1, 2)
        // 2, 1, 3, 4, 5
        // *     ^
        // (b) (t)
        // newLead: 3, 2, 1, 4, 5
        // current: * | head: ^

        int windowNode = 0;
        ListNode current = head;
        while (current != null && windowNode < windowLength) {
            reverseStack.push(current);
            current = current.next;
            windowNode++;
        }

        if (current == null && windowNode != windowLength) {
            // Not enough nodes to reverse `windowLength` nodes
            return head;
        } 

        head = reverseStack.peek();

        while (!reverseStack.isEmpty()) {
            ListNode newLead = reverseStack.pop();

            if (reverseStack.isEmpty()) {
                // The last node in the reversed segment should be joined
                // to the next window
                newLead.next = current;
            } else {
                ListNode newPost = reverseStack.peek();
                newLead.next = newPost;
            }
        }

        return head;
    }
}