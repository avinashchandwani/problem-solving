class BSTIterator {

    private List<Integer> nodes = null;
    private int currentIndex = 0;
    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        traverseInOrder(root, nodes);
    }
    
    public int next() {
        if(hasNext()) {
            return nodes.get(currentIndex++);
        }
        return -1;
    }
    
    public boolean hasNext() {
        return currentIndex < nodes.size();
    }
    
    private void traverseInOrder(TreeNode node, List<Integer> nodes) {
        if(node == null) return;
        traverseInOrder(node.left, nodes);
        nodes.add(node.val);
        traverseInOrder(node.right, nodes);
    }
}
