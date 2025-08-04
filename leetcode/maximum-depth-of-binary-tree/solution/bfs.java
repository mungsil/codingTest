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
        Queue<TreeNode> visits = new ArrayDeque<>();
        if(root != null){
            visits.offer(root);
        }

        int depth = 0;

        while(!visits.isEmpty()){
            depth++;
            int size = visits.size();
            for(int i=0; i < size; i++){
                TreeNode node = visits.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left != null){
                    visits.offer(left);
                }
                if(right != null){
                    visits.offer(right);
                }
            }
        }

        return depth;

    }

}
