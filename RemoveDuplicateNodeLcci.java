package leetcode.editor.cn;

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 链表 
// 👍 90 👎 0

public class RemoveDuplicateNodeLcci{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur = head;
        while (cur!=null){
            ListNode temp = cur;
            while(temp.next != null){
                if (temp.next.val == cur.val){
                    temp.next = temp.next.next;
                }else{
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}