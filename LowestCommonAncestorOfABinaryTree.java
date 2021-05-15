package leetcode.editor.cn;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
//最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
//（一个节点也可以是它自己的祖先）。”

// 示例 1：
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2：
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3：
//输入：root = [1,2], p = 1, q = 2
//输出：1

// 提示：
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 1002 👎 0

public class LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
        
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
        // 为了更方便的获取到最终结果, 使用一个成员变量来记录
        // 最近公共祖先 LCA
        public TreeNode lca = null;
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            // 我们期望在 find 递归的过程中, 找到 lca , 并且
            // 把结果放到 lca 成员变量中
            find(root, p, q);
            return lca;
        }

        // 只要当前 root 这个树中能找到 p 或者 q, 找到一个, 就返回 true
        public boolean find(TreeNode root, TreeNode p, TreeNode q) {
            // find 要做的事情就是针对当前节点 root 进行查找 p 和 q
            if (root == null) {
                // 空树里肯定找不到, 就返回 false
                return false;
            }
            // 使用 ? : 把 boolean 转换成 整数
            int mid = (root == p || root == q) ? 1 : 0;
            int left = find(root.left, p, q) ? 1 : 0;
            int right = find(root.right, p, q) ? 1 : 0;
            if (mid + left + right == 2) {
                // p 和 q 来自于 3 个渠道中的 2 个, 就认为找到了 lca
                lca = root;
            }
            // 只要找到了其中的 p 或者 q 中的一个, 都可以返回 true
            // 要是找到两个也是 返回 true
            // 一个都没找到才是返回 false
            return (left + right + mid) > 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}