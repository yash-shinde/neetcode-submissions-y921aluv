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
        //we need to know if both children are balanced and difference
        //of their heights is <=1
        return dfs(root)[0] == 1;
    }

    //we need a method that returns 2 things 
    //whether the subtree is balanced or not and its height
    private int[] dfs(TreeNode root){
        //1 = isbalanced 0=height
        if(root == null) return new int[]{1,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = left[0] == 1 && right[0] == 1 && 
        Math.abs(left[1] - right[1]) <= 1;

        int height = 1 + Math.max(left[1],right[1]);

        return new int[]{balanced ? 1 :0 , height};
    }
}
