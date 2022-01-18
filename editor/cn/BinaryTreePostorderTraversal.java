package leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 深度优先搜索 二叉树 👍 730 👎 0

import java.util.*;

public class BinaryTreePostorderTraversal{
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
// 递归解法
//class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        postorder(root, res);
//        return res;
//    }
//    void postorder (TreeNode cur, ArrayList<Integer> res){
//        if(cur == null){
//            return;
//        }
//        postorder(cur.left, res);
//        postorder(cur.right, res);
//        res.add(cur.val);
//    }
//}

// 迭代解法：栈，在前序遍历的基础上调换左右遍历次序，将最终结果列表反转
//class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        Deque<TreeNode> stk = new LinkedList<TreeNode>();
//        if (root == null){
//            return res;
//        }
//        stk.push(root);
//        while (!stk.isEmpty()){
//            TreeNode cur = stk.pop();
//            res.add(cur.val);
//            if (cur.left != null){
//                stk.push(cur.left);
//            }
//            if (cur.right != null){
//                stk.push(cur.right);
//            }
//        }
//        Collections.reverse(res);
//        return res;
//    }
//}
// 迭代方法：统一格式
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        if (root == null){
            return res;
        }
        stk.push(root);
        while (!stk.isEmpty()){
            TreeNode cur = stk.peek();
            if (cur != null){
                // 后续：左、右、中
                stk.pop();
                stk.push(cur);
                stk.push(null);
                if(cur.right != null) stk.push(cur.right);
                if(cur.left != null) stk.push(cur.left);
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

