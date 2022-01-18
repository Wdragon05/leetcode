package leetcode.editor.cn;
//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 469 👎 0

import java.util.HashSet;
import java.util.Set;2022-01-13 20:33:30

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length ==0 ||
        nums1 == null || nums2 == null){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1 : nums1){
            set1.add(num1);
        }

        for (int num2 : nums2){
            if (set1.contains(num2)){
                set2.add(num2);
            }
        }

        int[] res = new int[set2.size()];

        int index = 0;
        for (int num : set2){
            res[index++] = num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

