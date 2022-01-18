package leetcode.editor.cn;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。
// 找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1380 👎 0

import jdk.nashorn.internal.ir.WhileNode;2022-01-05 19:16:09
// 左闭右开
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] searchRange(int[] nums, int target) {
//        int left = search(nums, target);// 先找到第一个index
//        int right = search(nums, target + 1) - 1;// 再找第二个index：
//        // 在第一个index的基础上，跳过一个target，然后将得到的index-1.
//        if (left == nums.length || nums[left] != target) {
//        // 空元素和只有一个元素的情形 || 元素不存在的情形
//            return new int[]{-1, -1};
//        }
//        return new int[]{left, right};
//    }
//
//    public int search(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//            int midle = (left + right) / 2;
//            if (nums[midle] >= target) {
//                right = midle - 1;
//            } else {
//                left = midle + 1;
//            }
//        }
//        return left;
//    }
//}
// 左闭右闭
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = search(nums, target);// 先找到第一个index
        int right = search(nums, target + 1)-1;// 再找第二个index：
        // 在第一个index的基础上，跳过一个target，然后将得到的index-1.
        if (left == nums.length || nums[left] != target) {
            // 空元素和只有一个元素的情形 || 元素不存在的情形
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int midle = (left + right) / 2;
            if (nums[midle] >= target) {
                right = midle;
            } else {
                left = midle + 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

