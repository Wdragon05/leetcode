package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2892 👎 0

import java.util.*;2022-01-14 21:21:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
//        Stack<Character> st = null;
//        Queue<Character> st = new ArrayDeque<>();
        Deque<Character> st = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.toCharArray()[i] == '(') st.push(')');
            else if (s.toCharArray()[i] == '{') st.push('}');
            else if (s.toCharArray()[i] == '[') st.push(']');
            else if (st.isEmpty() || st.peek() != s.toCharArray()[i]){
                return false;
            }else st.pop();
        }
        return st.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

