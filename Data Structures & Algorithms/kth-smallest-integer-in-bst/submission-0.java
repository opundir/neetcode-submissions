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
    public TreeNode solve(TreeNode root, int[] k){
        if(root==null) return root;
        TreeNode left = solve(root.left,k);
        if(left!=null) return left;
        k[0]-=1;
        if(k[0]==0) return root;
        return solve(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] temp = {k};
        return solve(root,temp).val;
    }
}
