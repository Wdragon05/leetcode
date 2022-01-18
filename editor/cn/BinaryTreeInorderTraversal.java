package leetcode.editor.cn;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
//输出：[2,1]
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
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1212 👎 0

import java.util.*;

public class BinaryTreeInorderTraversal {
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
// 递归版
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        indor(root, res);
//        return res;
//
//    }
//    public void indor(TreeNode root, List<Integer> res){
//        if (root == null){
//            return;
//        }
//        indor(root.left, res);
//        res.add(root.val);
//        indor(root.right, res);
//    }
//}

// 迭代
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//
//        while (root != null || !stk.isEmpty()) {
//            while (root != null){
//                stk.push(root);
//                root = root.left;
//            }
//
//            root = stk.pop();
//            res.add(root.val);
//            root = root.right;
//        }
//        return res;
//
//    }
//}
// 迭代：中序遍历无法同时遍历和处理同一个节点，所以需要多一个指针来遍历二叉树
//class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//        if (root == null){
//            return res;
//        }
//        TreeNode cur = root;
//        while (cur != null || !stk.isEmpty()){
//            if(cur != null){
//                stk.push(cur);
//                cur = cur.left;
//            }else {
//                cur = stk.pop();
//                res.add(cur.val);
//                cur = cur.right;
//            }
//        }
//        return res;
//    }
//}

// 统一迭代形式，标记法
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        if (root == null){
            return res;
        }
        stk.push(root);

        while (!stk.isEmpty()){
            TreeNode cur = stk.peek();
            if (cur != null){// 左 中 右
                stk.pop();
                if (cur.right != null) stk.push(cur.right);
                stk.push(cur);
                stk.push(null);
                if (cur.left != null) stk.push(cur.left);
            }else{
                stk.pop();
                cur = stk.peek();
                res.add(cur.val);
                stk.pop();
            }
        }
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

