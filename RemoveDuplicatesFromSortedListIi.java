package leetcode.editor.cn;

//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1:
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5

// 示例 2:
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 465 👎 0

public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            //初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if(slow.next.val!=fast.next.val) {
                slow = slow.next;
                fast = fast.next;
            }
            else {
                //如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
                while(fast!=null && fast.next!=null && slow.next.val==fast.next.val) {
                    fast = fast.next;
                }
                slow.next = fast.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}