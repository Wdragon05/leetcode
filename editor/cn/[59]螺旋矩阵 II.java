package leetcode.editor.cn;
//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],
//       [8,9,4],
//       [7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 568 👎 0

2022-01-09 22:32:28

//leetcode submit region begin(Prohibit modification and deletion)
// 注意循环不变量！ 保持左闭右开或者左闭右闭的原则始终不改变
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startX = 0, startY = 0;//每次循环的起始点
        int count = 1;//存储循环值
        int loop = n / 2;// 循环次数
        int midIndex = n / 2;//当n为偶数时，中间的数需要单独处理，此为坐标
        int offset = 0;//控制每次循环的次数

        while (loop > 0) {
            // 从左至右上行填充，注意左闭右开，也就是说第一行最后一个index不赋值，
            // 在下一个区间赋值，一下处理类似
            int x = startX;
            int y = startY;
            for (; y < startY + n - offset - 1; y++) {
                res[startX][y] = count++;
            }

            // 最右列从上至下填充
            for (; x < startX + n - offset - 1; x++) {
                res[x][y] = count++;
            }

            // 最下行从右至左填充
            for (; y > startY; y--) {
                res[x][y] = count++;
            }

            // 最左行从下至上填充
            for (; x > startX; x--) {
                res[x][y] = count++;
            }

            loop--;
            startX++;
            startY++;//循环起始点一次加一

            offset += 2;// 循环长度比上一次少2
        }

        if (n % 2 != 0) {
            res[midIndex][midIndex] = count;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

