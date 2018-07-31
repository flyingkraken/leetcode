/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] store = new ArrayList[n+1];
        store[0] = new ArrayList<TreeNode>();
        if(n==0){
            return store[0];
        }
        store[0].add(null);
        
        for(int i=1;i<=n;i++){//动态规划
            store[i] = new ArrayList<TreeNode>();
            int[] num = new int[2];
            int[] offset = new int[2];
            
            for(int j=1;j<=i;j++){
                num[0] = j-1; offset[0] = 0;
                num[1] = i-j; offset[1] = j;
                addMyTrees(j, num, offset, i, store);
            }
        }
        return store[n];
    }
    
    public void addMyTrees(int root, int[] num, int[] offset, int target, List<TreeNode>[] store){
        for(TreeNode nodeL : store[num[0]]){
            for(TreeNode nodeR : store[num[1]]){
                TreeNode tmp = new TreeNode(root);
    
                TreeNode tmpNode2 = clone(nodeR, offset[1]);
                tmp.left = nodeL;//左子树没有offset，不需要复制对象再加offset
                tmp.right = tmpNode2;//右子树有offset，需要复制一个对象再加offset。否则会改变store[]中的对象
                store[target].add(tmp);
            }
        }
    }
    
    private TreeNode clone(TreeNode node, int offset){
        if(node == null){
            return null;
        }
        TreeNode res = new TreeNode(node.val+offset);
        
        res.left = clone(node.left, offset);
        res.right = clone(node.right, offset);
        
        return res;
    }
}
