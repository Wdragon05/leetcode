package leetcode.editor.cn;
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 591 👎 0

import java.util.*;

public class BinaryTreeRightSideView{
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
    public List<Integer> res= new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
//        recursiveLevelOeder(root, 0);
        BFS(root);
        return res;
    }
    public void recursiveLevelOeder(TreeNode node, Integer deep){
        if (node == null) {
            return;
        }
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
                if(len == 0){
                    res.add(cur.val);
                }
            }
            resList.add(leveList);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

