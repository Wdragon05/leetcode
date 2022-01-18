package leetcode.editor.cn;
//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1072 👎 0

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new  Solution();   
    
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
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
//class Solution {
//    public int maxDepth(TreeNode root) {
//        Queue<TreeNode> que = new LinkedList<>();
//        if (root == null) return 0;
//
//        que.offer(root);
//        int num = 0;
//        while (!que.isEmpty()){
//            int len = que.size();
//
//            for (int i = 0; i < len; i++) {
//                TreeNode cur = que.poll();
//                if (cur.left != null) que.offer(cur.left);
//                if (cur.right != null) que.offer(cur.right);
//            }
//            num++;
//        }
//        return num;
//    }
//}

class Solution {
    /**
     * 递归法
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

