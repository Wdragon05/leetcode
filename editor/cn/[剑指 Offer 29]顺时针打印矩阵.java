package leetcode.editor.cn;
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 👍 335 👎 0

2022-01-10 16:59:49

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 ||matrix[0].length == 0){
            return new int[]{};
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        int up = 0, left = 0;
        int down = m-1, right = n-1;
        int count = 0;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res[count++] = matrix[up][i];
            }

            for (int i = up+1; i <= down; i++) {
                res[count++] = matrix[i][right];
            }

            if (up == down || left == right) {
                break;
            }

            for (int i = right - 1; i >= left; i--) {
                res[count++] = matrix[down][i];
            }

            for (int i = down - 1; i > up; i--) {
                res[count++] = matrix[i][left];
            }
            left++;
            up++;
            right--;
            down--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

