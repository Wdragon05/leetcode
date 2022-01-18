package leetcode.editor.cn;
//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 238 👎 0

2022-01-15 22:06:57

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {
        StringBuffer res = new StringBuffer();
        int startPos = 0;
        int len = s.length();
        while (startPos < len) {
            StringBuffer tmp = new StringBuffer();
            int firstK, secondK;
            if (startPos + k > len) {
                firstK = len;
            } else {
                firstK = startPos + k;
            }

            if (startPos + 2 * k > len) {
                secondK = len;
            } else {
                secondK = startPos + 2 * k;
            }

            tmp.append((s.substring(startPos, firstK)));
            res.append(tmp.reverse());

            if (firstK < secondK) {
                res.append(s.substring(firstK, secondK));
            }

            startPos += 2 * k;

        }
    return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

