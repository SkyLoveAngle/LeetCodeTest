package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
// 示例： 
//二叉树：[3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7

// 返回其层序遍历结果：
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// Related Topics 树 广度优先搜索 
// 👍 811 👎 0

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        
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
/*递归实现
    //我们的策略是采取递归的方式进行先序遍历，把该节点的层数信息放到递归的方法参数之中。
    // result 就用于表示最终的结果,为了能够在递归方法中方便的进行更新, 把这个结果做成了一个成员变量.
    public List<List<Integer>> result = null;
    public List<List<Integer>> levelOrder(TreeNode root) {
        //我们需要保证每次调用 levelOrder 都创建新的 result,防止多个用例之间相互干扰.
        result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        // 我们的策略是采取递归的方式进行先序遍历, 把该节点的层数信息放到递归方法的参数中.
        helper(root, 0);
        return result;
    }


    public void helper(TreeNode root,int level){
        if (level == result.size()){
            // 如果满足这个条件, 意味着, 下面直接取下标就会出现
            // 越界的情况, 就需要给二维 List 中添加一个新行
            result.add(new ArrayList<Integer>());
        }
        // 就是一个简单的先序遍历.
        // 访问节点操作, 是把当前节点放到 result 的合适位置上.
        result.get(level).add(root.val);
        // 递归处理左右子树即可
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
 */

//链表实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while(queue.size()>0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}