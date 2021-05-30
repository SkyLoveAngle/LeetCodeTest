package leetcode.editor.cn;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//每一步只能移动到下一行中相邻的结点上。相邻的结点在这里指的是下标与上一层结点下标相同
//或者等于上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，
//那么下一步可以移动到下一行的下标 i 或 i + 1 。

//示例 1：
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

//示例 2：
//输入：triangle = [[-10]]
//输出：-10

// 提示：
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 

// 进阶：
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
// Related Topics 数组 动态规划 
// 👍 729 👎 0

public class Triangle{
    public static void main(String[] args) {
        Solution solution = new Triangle().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /*
    状态：子状态：从(n,n),(n,n-1),...(1,0),(1,1),(0,0)到最后一行的最短路径和
    F(i,j): 从(i,j)到最后一行的最短路径和

    状态递推：F(i,j) = min( F(i+1, j), F(i+1, j+1)) + triangle[i][j]

    初始值：F(n-1,0) = triangle[n-1][0],
    F(n-1,1) = triangle[n-1][1],..., F(n-1,n-1) = triangle[n-1][n-1]

    返回结果：F(0, 0)

    这种逆向思维不需要考虑边界，也不需要最后寻找最小值，直接返回F(0,0)即可
     */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        // F[n-1][n-1],...F[n-1][0]初始化
        ArrayList<ArrayList<Integer>> minPathSum = new ArrayList<>(triangle);
        int row = minPathSum.size();
        // 从倒数第二行开始
        for(int i = row - 2; i >= 0; --i){
            for(int j = 0; j <= i; ++j){
                // F(i,j) = min( F(i+1, j), F(i+1, j+1) ) + triangle[i][j]
                int curSum = Math.min(triangle.get(i + 1).get(j),
                        triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                minPathSum.get(i).set(j, curSum);
            }
        }
        return minPathSum.get(0).get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}