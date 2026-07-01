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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res);
    }

    private void dfsSerialize(TreeNode node,List<String> res){
        if(node == null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        dfsSerialize(node.left,res);
        dfsSerialize(node.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //tracks index
        int[] idx = {0};
        String[] nodes = data.split(",");
        return dfsDeserialize(nodes,idx);
    }

    private TreeNode dfsDeserialize(String[] nodes,int[] idx){
        //this child node is null 
        //process it and return control to caller
        //this condition ensures that a particular branch is ended
        if(nodes[idx[0]].equals("N")){
            idx[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]]));
        idx[0]++;
        root.left = dfsDeserialize(nodes,idx);
        //control comes here once the left branch encounters "N" in both of its paths
        root.right = dfsDeserialize(nodes,idx);
        return root;
    }
}
