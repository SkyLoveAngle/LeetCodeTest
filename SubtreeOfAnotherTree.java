package leetcode.editor.cn;

//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
//s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
//
// 示例 1: 
//给定的树 s:
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t：
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s：
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t：
//   4
//  / \
// 1   2

// 返回 false。 
// Related Topics 树 
// 👍 459 👎 0

public class SubtreeOfAnotherTree{
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //遍历s树，看树s上某个节点对应的的子树是否和树t相等
        //如果不相等，先递归判断s的左子树是否包含t树，再递归判断s的右子树是否包含t树
        if (s == null){
            return false;
        }
        boolean ret = isSameTree(s, t);
        if (ret) {
            return ret;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            // 进入这个条件意味着, 一定是 p 和 q 其中一个为空, 一个不为空
            return false;
        }
        // 都不为空树, 先判定根节点是不是值相同
        if (p.val != q.val) {
            return false;
        }
        // 根节点相同, 再分别比较左右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}