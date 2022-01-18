package leetcode.editor.cn;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1137 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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

// 层序遍历二叉树，就是图论中的广度优先遍历
// 广度优先遍历使用队列先进先出的特点实现
// 深度优先遍历的迭代算法使用栈的先入后出的特点实现
class Solution {
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
//        recursive(root, 0);
        if(root == null) return resList;
        BFS(root);
        return resList;
    }

    // 深度优先DFS：递归
//    public void recursive(TreeNode root, Integer deep) {
//        if (root == null) return;
//        deep++;
//
//        if (resList.size() < deep) {
//            List<Integer> leveList = new ArrayList<Integer>();
//            resList.add(leveList);
//        }
//
//        resList.get(deep - 1).add(root.val);
//
//        recursive(root.left, deep);
//        recursive(root.right, deep);
//    }

    // 广度优先BFS：队列，迭代
    public void BFS(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> leveList = new ArrayList<Integer>();
            int len = que.size();
            while (len > 0) {
                TreeNode cur = que.poll();
                leveList.add(cur.val);
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
                len--;
            }
            resList.add(leveList);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

