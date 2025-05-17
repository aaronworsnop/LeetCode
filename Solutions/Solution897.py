# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def increasingBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root: 
            return root

        self.output_list = []
        self.traversal(root)

        dummy = TreeNode()
        current = dummy
        for node in self.output_list:
            current.right = node
            node.left = None

            current = current.right

        return dummy.right

    def traversal(self, node: Optional[TreeNode]):
        if not node:
            return

        # left
        self.traversal(node.left)

        # me
        self.output_list.append(node)

        # right
        self.traversal(node.right)