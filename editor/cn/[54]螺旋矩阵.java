package leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 955 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Map;2022-01-10 15:23:02

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = m - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
//            if (up < down && left < right) {//不是一行或一列的情况时
            if (up == down || left == right) {
            // 当行数或者列数为奇数时，有可能上标和下标相等，左标和右标相等
                break;
            }

            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down - 1; i > up; i--) {
                res.add(matrix[i][left]);
            }
//            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

