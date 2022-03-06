package leetcode.editor.cn;
//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 410 👎 0

2022-03-06 15:49:18

/*
关于动态规划的问题，抓住五步曲：
1.确定dp数组以及下标的含义
2.确定递推公式
3.确定初始化条件
4.确定遍历顺序
5.举例推导dp数组
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {//1.确定dp[i]表示第i个数的菲波那切数列值
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;// 3.确定初始化条件
        for (int i = 2; i <= n; i++) {// 4.确定遍历顺序：是从前往后
            dp[i] = dp[i - 1] + dp[i - 2];// 2.确定递推公式
        }
        return dp[n];
//        return fib(n-1) + fib(n-2); // 递归版本
    }
}
//leetcode submit region end(Prohibit modification and deletion)

