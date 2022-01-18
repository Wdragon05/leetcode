package leetcode.editor.cn;
//给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下： 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[1,#,2,3,#,4,5,6,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 
//next 指针连接，'#' 标志着每一层的结束。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量少于 4096 
// -1000 <= node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 629 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        if (root == null) return null;

        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();
            List<Node> leveList = new ArrayList<>();
            Node tmp = que.peek();
            for (int i = 0; i < len; i++) {
                Node cur = que.poll();
                leveList.add(cur);
                if (cur.left != null) que.offer(cur.left);
                if (cur.right != null) que.offer(cur.right);
            }
            leveList.add(null);
            for (int j = 0; j < leveList.size() - 1; j++) {
                leveList.get(j).next = leveList.get(j + 1);
            }
        }
        return root;
    }
}
//class Solution {
//    public Node connect(Node root) {
//        Queue<Node> tmpQueue = new LinkedList<Node>();
//        if (root != null) tmpQueue.add(root);
//
//        while (tmpQueue.size() != 0){
//            int size = tmpQueue.size();
//
//            Node cur = tmpQueue.poll();
//            if (cur.left != null) tmpQueue.add(cur.left);
//            if (cur.right != null) tmpQueue.add(cur.right);
//
//            for (int index = 1; index < size; index++){
//                Node next = tmpQueue.poll();
//                if (next.left != null) tmpQueue.add(next.left);
//                if (next.right != null) tmpQueue.add(next.right);
//
//                cur.next = next;
//                cur = next;
//            }
//        }
//
//        return root;
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)

