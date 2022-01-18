package leetcode.editor.cn;
//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1546 👎 0

import java.util.HashMap;2022-01-07 22:05:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, res = Integer.MAX_VALUE;
        int isCount = 0, start = 0;
        for (int right = 0; right < s.length(); right++) {
            char RC = s.charAt(right);

            if (tMap.containsKey(RC)) {
                sMap.put(RC, sMap.getOrDefault(RC, 0) + 1);
                if (sMap.get(RC).equals(tMap.get(RC))) isCount++;
            }
            while (isCount == tMap.size()) {
                if (right - left + 1 < res) {
                    res = right - left + 1;
                    // 记录最小值一开始的位置
                    start = left;
                }
//                res = Math.min(res, right - left + 1);
                char LC = s.charAt(left);
                if (sMap.containsKey(LC)) {
                    if (sMap.get(LC).equals(tMap.get(LC))) {
                        isCount--;
                    }
                    sMap.put(LC, sMap.get(LC) - 1);
                }
                left++;
//                res = Math.min(res, right - left + 1);
            }

        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

