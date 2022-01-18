package leetcode.editor.cn;
//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 195 👎 0

2022-01-16 15:24:13

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if (s == null){
            return null;
        }
        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' '){
//                sb.append("%20");
//            }else {
//                sb.append(s.charAt(i));
//            }
//        }
        for (char c : s.toCharArray()){
            if (String.valueOf(c).equals(" ")){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

