/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int lht = height(root.left);
        int rht = height(root.right);
        if(Math.abs(lht - rht) <= 1){
            return isBalanced(root.left) 
            && isBalanced(root.right);
        }else return false;
    }

    private int height(TreeNode root){
        if(root == null)
        return 0;
        return 
            1 + Math.max(height(root.left),height(root.right));
    }
}
