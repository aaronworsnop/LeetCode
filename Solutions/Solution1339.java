class Solution {
    private static final long MOD = 1_000_000_007;

    List<Long> subtreeSums;

    public int maxProduct(TreeNode root) {
        if (root == null) {
	    	return 0;
	    }
    
	    subtreeSums = new LinkedList<>();
	    long totalSum = treeSum(root);
    
	    long maxProduct = 0;
	    for (long subtreeSum : subtreeSums) {
	    	long subtreeProduct = subtreeSum * (totalSum - subtreeSum);
	    	maxProduct = Math.max(maxProduct, subtreeProduct);
	    }
    
	    return (int) (maxProduct % MOD);
    }

    private long treeSum(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    
    	long leftSum = treeSum(node.left);
    	long rightSum = treeSum(node.right);
    
    	long currentSum = leftSum + rightSum + node.val;
    	subtreeSums.add(currentSum);
    
    	return currentSum;
    }
}