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

    public int maxDepth(TreeNode root) {
        return visitNode(root);
    }

    private int visitNode(TreeNode node){
        if(node == null){
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;

        return Math.max(visitNode(left), visitNode(right)) + 1;
    }

}
