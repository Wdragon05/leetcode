package leetcode.editor.cn;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 👍 1371 👎 0

2022-01-06 15:05:38

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, count = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }else {
                count++;
            }
        }
        for (int i = 1; i <= count; i++) {
            nums[nums.length - i] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

