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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.add(root);
        while (root != null || !stack.isEmpty()){
            while (root != null && root.left != null){
                stack.add(root.left);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            if (root.right != null){
                stack.add(root.right);
            }
            root = root.right;
        }
        for (int i=0; i < list.size(); i++){
            if (i!= 0 && list.get(i) <= list.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
