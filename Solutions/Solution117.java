/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node parent = null;
        Node current = null;
        Node next = root;

        while (next != null || parent != null) {
            if (parent == null) {
                current = null;
                parent = next;
                next = null;
            }

            if (parent.left != null) {
                if (next == null)
                    next = parent.left;
                if (current != null)
                    current.next = parent.left;
                current = parent.left;
            }

            if (parent.right != null) {
                if (next == null)
                    next = parent.right;
                if (current != null)
                    current.next = parent.right;
                current = parent.right;
            }

            parent = parent.next;
        }

        return root;
    }
}