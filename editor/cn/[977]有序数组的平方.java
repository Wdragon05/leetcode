package leetcode.editor.cn;
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 👍 393 👎 0

2022-01-07 16:33:46

//leetcode submit region begin(Prohibit modification and deletion)
// 暴力：M冒泡
//class Solution {
//    public int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        int tmp;
//        for (int j = 0; j < nums.length - 1; j++) {
//            for (int k = 0; k < nums.length - 1 - j; k++) {
//                if (nums[k] > nums[k+1]){
//                    tmp = nums[k];
//                    nums[k] = nums[k+1];
//                    nums[k+1] = tmp;
//                }
//            }
//        }
//        return nums;
//    }
//}

//双指针:首尾指针
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int[] res = new int[nums.length];
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] >nums[rightIndex]) {
                res[rightIndex - leftIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                res[rightIndex - leftIndex] = nums[rightIndex];
                rightIndex--;
            }
        }
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

