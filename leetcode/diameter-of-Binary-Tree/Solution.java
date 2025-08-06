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

    int longest;

    public int diameterOfBinaryTree(TreeNode root) {
        visit(root);

        return longest;
    }

    private int visit(TreeNode node){
        if(node == null){
            return -1;
        }

        int left = visit(node.left);
        int right = visit(node.right);

        longest = Math.max(longest, left+right+2); // 방문 노드를 루트로 하는 diameter 계산

        return Math.max(left, right)+1; // 깊이 계산
    }
}
