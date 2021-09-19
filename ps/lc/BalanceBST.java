/*
 https://leetcode.com/problems/balance-a-binary-search-tree/
 Capture inorder(sorted) order in a list then use Binary Search Technique to construct the tree.
*/
class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        captureInOrderNodes(root, nodes);
        return getBalancedTree(0, nodes.size()-1, nodes);
    }
    
    private void captureInOrderNodes(TreeNode node, List<Integer> nodes) {
        if(node == null) return;
        captureInOrderNodes(node.left, nodes);
        nodes.add(node.val);
        captureInOrderNodes(node.right, nodes);
    }
    
    private TreeNode getBalancedTree(int startIndex, int endIndex, List<Integer> nodes) {
        if(startIndex > endIndex) return null;
        int midIndex = (startIndex + endIndex)/2;
        TreeNode rootNode = new TreeNode(nodes.get(midIndex));
        rootNode.left = getBalancedTree(startIndex, midIndex - 1, nodes);
        rootNode.right = getBalancedTree(midIndex + 1, endIndex, nodes);
        return rootNode;
    }
}
