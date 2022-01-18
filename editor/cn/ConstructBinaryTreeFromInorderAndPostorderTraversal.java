package leetcode.editor.cn;
//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 642 👎 0

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length,
                postorder, 0, postorder.length);
    }

    public TreeNode buildTree1(int[] inorder, int inStart, int inLen,
                               int[] postorder, int postStart, int postLen) {

        if (postLen - postStart < 1) return null;
        if (inLen - inStart == 1) {
            TreeNode root1 = new TreeNode(inorder[inStart]);
            return root1;
        }

        int rootVal = postorder[postLen - 1];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = 0;
        for (int i = inStart; i < inLen; i++) {
            if (inorder[i] == rootVal) {
                inIndex = i;
                break;
            }
        }


        root.left = buildTree1(inorder, inStart, inIndex,
                postorder, postStart, postStart + inIndex - inStart);
        root.right = buildTree1(inorder, inIndex + 1, inLen,
                postorder, postStart + inIndex - inStart, postLen - 1);

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

