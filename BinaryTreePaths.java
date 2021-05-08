package leetcode.editor.cn;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。
// 说明: 叶子节点是指没有子节点的节点。
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 465 👎 0

public class BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;
    }

    public void dfs(TreeNode root,String path,List<String> res){
        //如果为空，直接返回
        if (root == null){
            return ;
        }
        //如果是叶子节点，说明找到一条路径，把它加入到res
        if (root.left == null &&root.right == null){
            res.add(path + root.val);
            return;
        }
        //如果不是叶子节点，在分别遍历他的左右子节点
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}