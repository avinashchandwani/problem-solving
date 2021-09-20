class ConstructTreeFromString {
    public TreeNode str2tree(String s) {
        return constructTree(s);
    }
    
    private TreeNode constructTree(String s) {
        if(s == null || s.isEmpty()) return null;
        if(!s.contains("(")){
            return new TreeNode(Integer.parseInt(s));
        }
        System.out.println(s);
        int nodeValue = Integer.parseInt(s.substring(0, s.indexOf("(")));
        TreeNode currentNode = new TreeNode(nodeValue);
        int leftEndIndex = getLeftNodeEndIndex(s, s.indexOf("("));
        currentNode.left = constructTree(s.substring(s.indexOf("(") +1, leftEndIndex));
        if(leftEndIndex < s.length()-1) {
             currentNode.right = constructTree(s.substring(leftEndIndex+2, s.length()-1));
        }
        return currentNode;
    }
    
    private int getLeftNodeEndIndex(String s, int startIndex) {
        int openParanthesis = 0;
        for(int i=startIndex; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                openParanthesis +=1;
            } else if(s.charAt(i) == ')'){
                openParanthesis -=1;
                if(openParanthesis == 0)
                    return i;
            }
        }
        return -1;
    }
}
