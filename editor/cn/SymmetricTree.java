package leetcode.editor.cn;
//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1676 👎 0

import jdk.nashorn.internal.ir.Flags;

import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// 层序遍历BFS
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        boolean flg = true;
        que.offer(root.left);
        que.offer(root.right);
        while (!que.isEmpty()) {
            TreeNode leftNode = que.poll();
            TreeNode rightNode = que.poll();
            if(leftNode == null && rightNode == null) continue;

            if(leftNode == null || rightNode == null || leftNode.val != rightNode.val){
                return false;
            }

            que.offer(leftNode.right);
            que.offer(rightNode.left);
            que.offer(leftNode.left);
            que.offer(rightNode.right);

        }
        return flg;
    }
}

// 递归DFS
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return compare(root.left, root.right);
//
//    }
//
//    public boolean compare(TreeNode left, TreeNode right){
//        if(left == null && right != null) return false;
//        if(left != null && right == null) return false;
//        if(left == null && right == null) return true;
//        if(left.val != right.val) return false;
//
//        boolean outside = compare(left.left, right.right);
//        boolean inside = compare(left.right, right.left);
//        boolean flg = outside && inside;
//        return flg;
//    }
//}
//leetcode submit region end(Prohibit modification and deletion)

