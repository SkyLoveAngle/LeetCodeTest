package leetcode.editor.cn;

//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 524 👎 0

public class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
        
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
    public ListNode removeElements(ListNode head, int val) {
       /*
        if (head==null){
            return null;
        }
        //删除操作需要单独考虑待删除元素是头结点的情况
        if (head.val == val){
            head=head.next;
        }
        //接下来看要是删除的元素是中间元素，则需要找到该需要删除节点的前一个节点
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if (cur.val == val){
                //如果cur.val==val，就说明找到了要删除节 点，接下来就是要进行删除操作
                prev.next=cur.next;
                cur=prev.next;
            }else{
                //如果没有找到，更新prev和cur的位置
                prev=prev.next;
                cur=cur.next;
            }
        }
        return head;
        */
//1,1,2,3,4,1这样的情况会出现问题

        if (head==null){
            return null;
        }
        //接下来看要是删除的元素是中间元素，则需要找到该需要删除节点的前一个节点
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if (cur.val == val){
                //如果cur.val==val，就说明找到了要删除节点，接下来就是要进行删除操作
                prev.next=cur.next;
                cur=cur.next;
            }else{
                //如果没有找到，更新prev和cur的位置
                prev=prev.next;
                cur=cur.next;
            }
        }
        //删除操作需要单独考虑待删除元素是头结点的情况
        if (head.val == val){
            head=head.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}