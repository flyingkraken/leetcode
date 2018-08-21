/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    Integer maxDepth = new Integer(0);
    public int diameterOfBinaryTree(TreeNode root) {
        
        findDepth(root, maxDepth);
        return (int)maxDepth;
        
    }
    
    private int findDepth(TreeNode node, Integer maxDepth){
        if(node==null){
            return 0;
        }
        
        int leftDepth = node.left==null?0:1;
        int rightDepth = node.right==null?0:1;
        leftDepth += findDepth(node.left,this.maxDepth);
        rightDepth += findDepth(node.right,this.maxDepth);

        //int depth = Math.max(leftDepth, rightDepth)+Math.max(findDepth(node.left,maxDepth), findDepth(node.right, maxDepth));
        this.maxDepth = Math.max(this.maxDepth, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth);
    }
}*/
//以上我的算法，太慢了
//以下为别人的算法，思想类似，但是更简单一些
class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        trackDown(root);
        return max;
    }
    
    public int trackDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = trackDown(root.left);
        int right = trackDown(root.right);
        int dia = left + right;
        if (dia > max) {
            max = dia;
        }
        return Math.max(left, right) + 1;
    }
}
 
