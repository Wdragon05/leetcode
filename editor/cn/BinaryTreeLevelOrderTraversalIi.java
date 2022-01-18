package leetcode.editor.cn;
//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 523 👎 0

import java.util.*;

public class BinaryTreeLevelOrderTraversalIi{
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
class Solution {
    public List<List<Integer>> resList= new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return resList;
//        recursiveLevelOeder(root, 0);
        BFS(root);
        Collections.reverse(resList);
        return resList;
    }

    public void recursiveLevelOeder(TreeNode node, Integer deep){
        if (node == null) return;
        deep++;
        if (resList.size() < deep){
            List<Integer> leveList = new ArrayList<Integer>();
            resList.add(leveList);
        }
        resList.get(deep - 1).add(node.val);

        recursiveLevelOeder(node.left, deep);
        recursiveLevelOeder(node.right, deep);
    }

    public void BFS(TreeNode node){
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while (!que.isEmpty()){
            List<Integer> leveList = new ArrayList<>();
            int len = que.size();
            while (len > 0){
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

