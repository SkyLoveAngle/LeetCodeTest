package leetcode.editor.cn;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。 
//
// 返回删除后的链表的头节点。 
//
// 注意：此题对比原题有改动 
//
// 示例 1: 
//
// 输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
// 
//
// 示例 2: 
//
// 输入: head = [4,5,1,9], val = 1
//输出: [4,5,9]
//解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
// 
//
// 
//
// 说明： 
//
// 
// 题目保证链表中节点的值互不相同 
// 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点 
// 
// Related Topics 链表 
// 👍 97 👎 0

public class ShanChuLianBiaoDeJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new ShanChuLianBiaoDeJieDianLcof().new Solution();
        
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
    public ListNode deleteNode(ListNode head, int value) {
        if (head==null){
            return head;
        }
        if (head.val == value){
            //这就表示要删除的节点是头结点.
            head=head.next;
            return head;
        }
        // 1. 先找到 val 这个值对应的位置,同时也要找到 val 的前一个位置.
        ListNode prev = head;
        while (prev != null
                && prev.next != null
                && prev.next.val != value) {
            prev = prev.next;
        }
        // 循环结束之后, prev 就指向待删除节点的前一个节点了.
        if (prev == null || prev.next == null) {
            // 没有找到值为 val 的节点.
            //System.out.print("遍历该链表后，没有找到你想删除的元素！");
            return head;
        }
        // 2. 真正进行删除了, toDelete 指向要被删除的节点.
        ListNode toDelete = prev.next;
        prev.next = toDelete.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}