package leetcode.editor.cn;

//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1484 👎 0

public class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        
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
    public ListNode reverseList(ListNode head) {
        if (head ==null){
            return null;
        }
        if (head.next==null){
            //连表里只有一个元素
            return head;
        }
        //处理一般情况
        ListNode newhead=null;
        ListNode prevNode=null;
        ListNode curNode=head;
        while(curNode!=null){
            //进入循环需要先设定好nextNode的位置
            ListNode nextNode =curNode.next;
            if (nextNode==null){
                //curNode指向链表的最后一个位置
                //也就是反转后新链表的头结点
                newhead = curNode;
            }
            //往回指
            curNode.next=prevNode;
            //更新位置，往下继续
            prevNode=curNode;
            curNode=nextNode;
        }
        return newhead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}