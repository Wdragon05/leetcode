package leetcode.editor.cn;
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1226 👎 0

import java.util.ArrayList;
import java.util.List;2022-01-11 16:56:13

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// 复制链表至数组然后使用双指针
//class Solution {
//    public boolean isPalindrome(ListNode head) {
//        List<Integer> arr = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null){
//            arr.add(cur.val);
//            cur = cur.next;
//        }
//
//        int left = 0, right = arr.size()-1;
//        while (left < right){
//            if (!arr.get(left).equals(arr.get(right))){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//}
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode cur1 = head;
        ListNode cur2 = secondHalfStart;

        while (cur2 != null){
            if(cur1.val != cur2.val){
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return true;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode tmp;
        ListNode cur = head;
        while (cur !=null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

