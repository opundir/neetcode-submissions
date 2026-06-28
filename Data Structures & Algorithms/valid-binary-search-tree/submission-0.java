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
    boolean solve(TreeNode root, TreeNode maxi, TreeNode mini){
        if(root==null) return true;
        boolean left = true;
        if(maxi!=null && root.val>=maxi.val) left = false;
        boolean right = true;
        if(mini!=null && root.val<=mini.val) right = false;
        if(!left || !right) return false;
        return solve(root.left,root,mini) && solve(root.right,maxi,root);

    }
    public boolean isValidBST(TreeNode root) {
        return solve(root,null,null);
    }
}
