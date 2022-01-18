package leetcode.editor.cn;
//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 👍 253 👎 0

import java.util.*;2022-01-13 19:35:08

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] words) {
        int[] array1 = new int[26];
        List<String> res = new ArrayList<>();
//        Map<Character, Integer> map2 = new HashMap<>();
        for (char s : words[0].toCharArray()) {
            array1[s- 'a'] +=1;
        }
        for (int i = 1; i < words.length; i++) {
            int[] array2 = new int[26];
            for (char s : words[i].toCharArray()){
                array2[s - 'a'] +=1;
            }
            for (int j = 0; j < 26; j++) {
                array1[j] = Math.min(array1[j], array2[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < array1[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

