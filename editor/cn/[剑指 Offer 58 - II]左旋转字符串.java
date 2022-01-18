package leetcode.editor.cn;
//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。 
//
// 
//
// 示例 1： 
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
// 
//
// 示例 2： 
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
// 
//
// 
//
// 限制： 
//
// 
// 1 <= k < s.length <= 10000 
// 
// Related Topics 数学 双指针 字符串 👍 186 👎 0

2022-01-16 20:02:36

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuffer sb = new StringBuffer(s);
        reverseString(sb,0, n-1);
        reverseString(sb,n, len-1);
        return sb.reverse().toString();
    }
    // 反转字符串
    private void reverseString(StringBuffer sb, int start , int end){
        while (start < end){
            char tmp =sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

