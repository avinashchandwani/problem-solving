class BSTClosestValue {
    
    public int closestValue(TreeNode root, double target) {
        List<Integer> nodes = new ArrayList<>();
        inOrderNodes(root, nodes);
        if(target < nodes.get(0)) return nodes.get(0);
        if(target > nodes.get(nodes.size() - 1)) return nodes.get(nodes.size() - 1);
        for(int currentIndex = 1; currentIndex < nodes.size(); currentIndex++) {
            if(target >= nodes.get(currentIndex - 1) && target <= nodes.get(currentIndex)) {
                if(target - nodes.get(currentIndex - 1) > nodes.get(currentIndex) - target) {
                    return nodes.get(currentIndex);
                } else {
                    return nodes.get(currentIndex - 1);
                }
            }
        }
        return -1;
    }
    
    private void inOrderNodes(TreeNode node, List<Integer> nodes) {
        if(node == null) return;
        inOrderNodes(node.left, nodes);
        nodes.add(node.val);
        inOrderNodes(node.right, nodes);
    }
}
