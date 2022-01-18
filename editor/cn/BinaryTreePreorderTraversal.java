package leetcode.editor.cn;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 709 👎 0

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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

// 递归实现
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        preorder(root, res);
//        return res;
//    }
//
//    void preorder (TreeNode cur, ArrayList<Integer> res){
//        if(cur == null){
//            return;
//        }
//        res.add(cur.val);
//        preorder(cur.left, res);
//        preorder(cur.right, res);
//    }
//}

// 迭代实现 栈,前序遍历访问和处理同时实现
//class Solution {
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//        if (root == null) {
//            return res;
//        }
//        stk.push(root);
//        while (!stk.isEmpty()) {
//            TreeNode cur = stk.pop();
//            res.add(cur.val);
//            if (cur.right != null){
//                stk.push(cur.right);
//            }
//            if (cur.left != null){
//                stk.push(cur.left);
//            }
//        }
//        return res;
//    }
//}
// 前中后统一形式：将访问的节点放入栈中，把处理的节点也放入栈中，但是要做标记
// 标记：要处理的节点放入栈后，紧接着放入一个空指针作为标记
// 要处理的意思就是要将当前节点加入到结果队列中
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        if (root == null) {
            return res;
        }
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode tp = stk.peek();
            if (tp != null) {// 遍历并压入栈，先将栈结构一次性构造完成
                // 前序遍历的顺序在栈中的相反的：右、左、中（当前）
                stk.pop();
                if (tp.right != null) stk.push(tp.right);
                if (tp.left != null) stk.push(tp.left);
                stk.push(tp);// 要处理的节点
                stk.push(null);// 要处理的节点的标记
            } else {// null出栈并将下一个加入res队列
                stk.pop();
                tp = stk.peek();
                res.add(tp.val);
                stk.pop();
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

