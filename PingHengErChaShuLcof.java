package leetcode.editor.cn;

//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
//如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

// 示例 1:
// 给定二叉树 [3,9,20,null,null,15,7]
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 


//示例 2:
// 给定二叉树 [1,2,2,3,3,null,null,4,4]
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
//
// 返回 false 。 

// 限制：
// 0 <= 树的结点个数 <= 10000
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
// Related Topics 树 深度优先搜索 
// 👍 125 👎 0

public class PingHengErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }else{
            return false;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int maxdepth = 0;
        if (leftHeight >= rightHeight) {
            maxdepth = leftHeight;
        } else {
            maxdepth = rightHeight;
        }
        return 1 + maxdepth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}