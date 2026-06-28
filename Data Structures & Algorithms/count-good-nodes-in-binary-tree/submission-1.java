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
    int ans = 0;
    void solve(TreeNode root, int arr){
        if(root==null) return;
        if(root.val>=arr) ans++;
        arr = Math.max(root.val,arr);
        solve(root.left,arr);
        solve(root.right,arr);
    }
    public int goodNodes(TreeNode root) {
        int arr = Integer.MIN_VALUE;
        solve(root,arr);
        return ans;
    }
}
