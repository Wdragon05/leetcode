package leetcode.editor.cn;
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 879 👎 0

import sun.print.SunMinMaxPage;

import java.util.Arrays;2022-01-07 17:20:15

//leetcode submit region begin(Prohibit modification and deletion)
// 暴力循环
//class Solution {
//    public int minSubArrayLen(int target, int[] nums) {
//        int res = Integer.MAX_VALUE, sum = 0, subLen = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if(sum >= target){
//                    subLen = j-i+1; //子序列的长度
//                    if (subLen < res){
//                        res = subLen;
//                        break;
//                    }
//                }
//            }
//        }
//        if (res == Integer.MAX_VALUE){
//            return 0;
//        }else {
//            return res;
//        }
//
//    }
//}

// 滑动窗口，也是双指针
//class Solution {
//    public int minSubArrayLen(int target, int[] nums) {
//        int left = 0, right = 0;
//        int sum = 0, subLen = 0,res=Integer.MAX_VALUE;
//        while (right < nums.length){
//            sum = 0;
//            for (int i = left; i <= right; i++) {
//                sum += nums[i];
//            }
//            if (sum >= target){
//                subLen = right - left + 1;
//                if (subLen < res){
//                    res = subLen;
//                }
//                left++;
//            }else {
//                right++;
//            }
//        }
//        if (res == Integer.MAX_VALUE){
//            return 0;
//        }else {
//            return res;
//        }
//    }
//}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0, subLen = 0,res=Integer.MAX_VALUE;
        while (right < nums.length){
            sum +=nums[right];
            while (sum >= target){
                subLen = right - left + 1;
                if (subLen < res){
                    res = subLen;
                }
                sum -= nums[left++];
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

